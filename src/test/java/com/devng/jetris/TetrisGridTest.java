package com.devng.jetris;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TetrisGridTest {
    private TetrisGrid tg;

    @BeforeEach
    public void setup() {
        tg = new TetrisGrid();
    }

    @Test
    public void testGetLevelInitial() {
        assertEquals(0, tg.getLevel());
    }

    @Test
    public void testGetLinesInitial() {
        assertEquals(0, tg.getLines());
    }

    @Test
    public void testGetScoreInitial() {
        assertEquals(0, tg.getScore());
    }

    @Test
    public void testDropLinesInitial() {
        assertArrayEquals(new int[]{0,0,0,0}, tg.getDropLines());
    }

    @Test
    public void testResetStatsInitial() {
        tg.resetStats();
        assertEquals(0, tg.getLevel());
        assertEquals(0, tg.getLines());
        assertEquals(0, tg.getScore());
        assertArrayEquals(new int[]{0,0,0,0}, tg.getDropLines());
    }

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

    @Test
    public void testIsNextMoveValidFalse() {
        Figure f = new FigureI();
        assertFalse(tg.isNextMoveValid(f,10,10));
    }

    @Test
    public void testIsNextMoveValidTrue() {
        Figure f = new FigureO();
        assertTrue(tg.isNextMoveValid(f,4,0));
    }

    @Test
    public void testAddFigureToGridFalse() {
        Figure f = new FigureI();

        assertFalse(tg.addFigure(f));
        assertEquals(f.offsetX, 4);
        assertEquals(f.offsetY, 0);
    }

    @Test
    public void testAddFigureToGridTrueOffScreen() {
        Figure f = new FigureJ();
        f.setOffset(10,100);
        assertTrue(tg.addFigure(f));
    }

    @Test
    public void testAddFigureToGridTrueValidMove() {
        Figure f = new FigureJ();
        tg.gLines.set(0,new int[]{3,3,3,4,4,4,3,2,1,1});
        assertTrue(tg.addFigure(f));
    }

    @Test
    public void testIsGameOverFalse() {
        Figure f = new FigureS();
        assertFalse(tg.isGameOver(f));
    }

    @Test
    public void testIsGameOverTrue() {
        tg.gLines.set(0,new int[]{1,1,1,1,1,1,1,1,1,1});
        Figure f = new FigureL();
        assertTrue(tg.isGameOver(f));
    }

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
        assertTrue(Arrays.equals(new int[]{0,0,0,0}, tg.getDropLines()));
    }

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
}
