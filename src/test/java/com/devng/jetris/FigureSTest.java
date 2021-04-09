package com.devng.jetris;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FigureSTest {
    private FigureS figureS;

    @BeforeEach
    public void setup() {
        figureS = new FigureS();
    }

    @Test
    public void testFigureSGetMaxRightOffset() {
        assertEquals(6,figureS.getMaxRightOffset());
    }

    @Test
    public void testFigureSResetOffset() {
        figureS.resetOffsets();
        assertEquals(0, figureS.offsetX);
        assertEquals(0, figureS.offsetY);
        assertEquals(0, figureS.offsetXLast);
        assertEquals(0, figureS.offsetYLast);
    }

    @Test
    public void testFigureSSetOffset() {
        figureS.setOffset(123,2);
        assertEquals(123, figureS.offsetX);
        assertEquals(2, figureS.offsetY);
        assertEquals(4, figureS.offsetXLast);
        assertEquals(0, figureS.offsetYLast);
    }

    @Test
    public void testFigureSResetOffsetGetMaxRightOffset() {
        figureS.resetOffsets();
        assertEquals(2, figureS.getMaxRightOffset());
    }

    @Test
    public void testFigureSSetOffsetGetMaxRightOffset() {
        figureS.setOffset(-1,7);
        assertEquals(1, figureS.getMaxRightOffset());
    }

    @Test
    public void testFigureSRotationRight() {
        figureS.rotationRight();
        assertArrayEquals(new int[]{0,0,1,1},figureS.arrX);
        assertArrayEquals(new int[]{0,1,1,2},figureS.arrY);
    }

    @Test
    public void testFigureSRotationLeft() {
        figureS.rotationLeft();
        assertArrayEquals(new int[]{0,0,1,1},figureS.arrX);
        assertArrayEquals(new int[]{0,1,1,2},figureS.arrY);
    }

    @Test
    public void testFigureSRotationRight2() {
        figureS.rotationRight();
        figureS.rotationRight();
        assertArrayEquals(new int[]{0,1,1,2},figureS.arrX);
        assertArrayEquals(new int[]{1,0,1,0},figureS.arrY);
    }

    @Test
    public void testFigureSRotationLeft2() {
        figureS.rotationLeft();
        figureS.rotationLeft();
        assertArrayEquals(new int[]{0,1,1,2},figureS.arrX);
        assertArrayEquals(new int[]{1,0,1,0},figureS.arrY);
    }

    @Test
    public void testFigureSRightLeft() {
        figureS.rotationRight();
        figureS.rotationLeft();
        assertArrayEquals(new int[]{0,1,1,2},figureS.arrX);
        assertArrayEquals(new int[]{1,0,1,0},figureS.arrY);
    }

    @Test
    public void testFigureSLeftRight() {
        figureS.rotationLeft();
        figureS.rotationRight();
        assertArrayEquals(new int[]{0,1,1,2},figureS.arrX);
        assertArrayEquals(new int[]{1,0,1,0},figureS.arrY);
    }

    @Test
    public void testFigureSGetGridVal() {
        assertEquals(Figure.S, figureS.getGridVal());
    }

    @Test
    public void testFigureSGetColor() {
        assertEquals(Figure.COL_S, figureS.getColor());
    }
}
