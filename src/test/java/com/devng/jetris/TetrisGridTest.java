package com.devng.jetris;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TetrisGridTest {
    private TetrisGrid tg;

    @BeforeEach
    public void setup() {
        tg = new TetrisGrid();
        File file = new File(GV.DAT_FILE);
        if (file.exists()) {
            file.delete();
        }
    }

    /* Test that the level is initially 0 */
    @Test
    public void testGetLevelInitial() {
        assertEquals(0, tg.getLevel());
    }

    /* Test that the number of lines cleared is initially 0 */
    @Test
    public void testGetLinesInitial() {
        assertEquals(0, tg.getLines());
    }

    /* Test that the score is initially 0 */
    @Test
    public void testGetScoreInitial() {
        assertEquals(0, tg.getScore());
    }

    /* Test that the number of dropped lines is initially 0 */
    @Test
    public void testDropLinesInitial() {
        assertArrayEquals(new int[]{0,0,0,0}, tg.getDropLines());
    }

    /* Test that resetting stats reverts to 0's */
    @Test
    public void testResetStatsInitial() {
        tg.resetStats();
        assertEquals(0, tg.getLevel());
        assertEquals(0, tg.getLines());
        assertEquals(0, tg.getScore());
        assertArrayEquals(new int[]{0,0,0,0}, tg.getDropLines());
    }

    /* Test that toString prints out gLines, which is initially all 0 */
    @Test
    public void testToStringInitial() {
        assertEquals("0000000000\n" +
                "0000000000\n" +
                "0000000000\n" +
                "0000000000\n" +
                "0000000000\n" +
                "0000000000\n" +
                "0000000000\n" +
                "0000000000\n" +
                "0000000000\n" +
                "0000000000\n" +
                "0000000000\n" +
                "0000000000\n" +
                "0000000000\n" +
                "0000000000\n" +
                "0000000000\n" +
                "0000000000\n" +
                "0000000000\n" +
                "0000000000\n" +
                "0000000000\n" +
                "0000000000\n", tg.toString());
    }

    /* Check that next move is not valid when offsets are too large */
    @Test
    public void testIsNextMoveValidFalse() {
        Figure f = new FigureI();
        assertFalse(tg.isNextMoveValid(f,10,10));
    }

    /* Check that next move is valid with default offsets */
    @Test
    public void testIsNextMoveValidTrue() {
        Figure f = new FigureO();
        assertTrue(tg.isNextMoveValid(f,4,0));
    }

    /* Check that figures can't be added to grid until they "reach the bottom"
    * or are off-screen */
    @Test
    public void testAddFigureToGridFalse() {
        Figure f = new FigureI();

        assertFalse(tg.addFigure(f));
        assertEquals(f.offsetX, 4);
        assertEquals(f.offsetY, 0);
    }

    /* Check that if the grid is full the figure must be deposited off-screen */
    @Test
    public void testAddFigureToGridTrueOffScreen() {
        Figure f = new FigureJ();
        f.setOffset(10,100);
        assertTrue(tg.addFigure(f));
    }

    /* Check that the figure is added to grid once it reaches the bottom */
    @Test
    public void testAddFigureToGridTrueValidMove() {
        Figure f = new FigureJ();
        tg.gLines.set(0,new int[]{3,3,3,4,4,4,3,2,1,1});
        assertTrue(tg.addFigure(f));
        assertEquals(100 + 5 * tg.getLevel(), tg.getScore());
    }

    /* Check that when a figure can still move down, game is not over */
    @Test
    public void testIsGameOverFalse() {
        Figure f = new FigureS();
        assertFalse(tg.isGameOver(f));
    }

    /* Check that when a figure can't move down anymore that the game is over */
    @Test
    public void testIsGameOverTrue() {
        tg.gLines.set(0,new int[]{1,1,1,1,1,1,1,1,1,1});
        Figure f = new FigureL();
        assertTrue(tg.isGameOver(f));
    }

    /* Check that resetting stats after gameplay resets back to 0 */
    @Test
    public void testResetStats() {
        tg.setLines(2);
        tg.setLevel(3);
        tg.setScore(2140);
        tg.setDropLines(new int[]{2,3,4,5});
        tg.resetStats();
        assertEquals(0, tg.getLines());
        assertEquals(0, tg.getLevel());
        assertEquals(0, tg.getScore());
        assertArrayEquals(new int[]{0, 0, 0, 0}, tg.getDropLines());
    }

    /* Check that HiScore updates as expected */
    @Test
    public void testUpdateHiScore() {
        tg.setLines(2);
        tg.setScore(400);
        tg.updateHiScore();
        assertEquals(400, tg.hiScore[0].score);
        assertEquals(2, tg.hiScore[0].lines);
        tg.setLines(3);
        tg.setScore(300);
        tg.updateHiScore();
        assertEquals(400, tg.hiScore[0].score);
        assertEquals(2, tg.hiScore[0].lines);
        assertEquals(300, tg.hiScore[1].score);
        assertEquals(3, tg.hiScore[1].lines);
        tg.setLines(8);
        tg.setScore(2600);
        tg.updateHiScore();
        assertEquals(2600, tg.hiScore[0].score);
        assertEquals(8, tg.hiScore[0].lines);
        assertEquals(400, tg.hiScore[1].score);
        assertEquals(2, tg.hiScore[1].lines);
        assertEquals(300, tg.hiScore[2].score);
        assertEquals(3, tg.hiScore[2].lines);
        tg.setLines(10);
        tg.setScore(3000);
        tg.updateHiScore();
        assertEquals(3000, tg.hiScore[0].score);
        assertEquals(10, tg.hiScore[0].lines);
        assertEquals(2600, tg.hiScore[1].score);
        assertEquals(8, tg.hiScore[1].lines);
        assertEquals(400, tg.hiScore[2].score);
        assertEquals(2, tg.hiScore[2].lines);
    }

    /* Test clearing two lines at once */
    @Test
    public void testEliminateLines2() {
        Figure f = new FigureS();
        tg.gLines.set(0,new int[]{3,3,3,4,4,4,3,2,1,1});
        tg.gLines.set(1,new int[]{3,3,2,4,4,5,5,2,1,1});
        assertTrue(tg.addFigure(f));
        assertEquals(400 + 20 * tg.getLevel(), tg.getScore());
    }

    /* Test clearing three lines at once */
    @Test
    public void testEliminateLines3() {
        Figure f = new FigureL();
        tg.gLines.set(0,new int[]{3,3,3,4,4,4,3,2,1,1});
        tg.gLines.set(1,new int[]{3,3,2,4,4,5,5,2,1,1});
        tg.gLines.set(2,new int[]{2,4,4,5,5,2,1,1,6,6});
        assertTrue(tg.addFigure(f));
        assertEquals(900 + 45 * tg.getLevel(), tg.getScore());
    }

    /* Test clearing four lines at once */
    @Test
    public void testEliminateLines4() {
        Figure f = new FigureI();
        tg.gLines.set(0,new int[]{3,3,3,4,4,4,3,2,1,1});
        tg.gLines.set(1,new int[]{3,3,2,4,4,5,5,2,1,1});
        tg.gLines.set(2,new int[]{2,4,4,5,5,2,1,1,6,6});
        tg.gLines.set(3,new int[]{3,3,4,5,2,1,1,2,3,4});
        assertTrue(tg.addFigure(f));
        assertEquals(1600 + 80 * tg.getLevel(), tg.getScore());
    }

    /* Test that saving HiScore creates new file */
    @Test
    public void testSaveHiScore() {
        File file = new File(GV.DAT_FILE);
        assertFalse(file.exists());
        tg.saveHiScore("Name",0);
        assertTrue(file.exists());
    }
}
