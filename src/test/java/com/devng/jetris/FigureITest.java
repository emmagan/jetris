package com.devng.jetris;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FigureITest {
    private FigureI figureI;

    @BeforeEach
    public void setup() {
        figureI = new FigureI();
    }

    @Test
    public void testFigureIGetMaxRightOffset() {
        assertEquals(4,figureI.getMaxRightOffset());
    }

    @Test
    public void testFigureIResetOffset() {
        figureI.resetOffsets();
        assertEquals(0, figureI.offsetX);
        assertEquals(0, figureI.offsetY);
        assertEquals(0, figureI.offsetXLast);
        assertEquals(0, figureI.offsetYLast);
    }

    // Probably shouldn't have negative values? Check during integration test
    @Test
    public void testFigureISetOffset() {
        figureI.setOffset(10,2);
        figureI.setOffset(-2,10);
        assertEquals(-2, figureI.offsetX);
        assertEquals(10, figureI.offsetY);
        assertEquals(10, figureI.offsetXLast);
        assertEquals(2, figureI.offsetYLast);
    }

    @Test
    public void testFigureIResetOffsetGetMaxRightOffset() {
        figureI.resetOffsets();
        assertEquals(0, figureI.getMaxRightOffset());
    }

    @Test
    public void testFigureISetOffsetGetMaxRightOffset() {
        figureI.setOffset(4,7);
        assertEquals(4, figureI.getMaxRightOffset());
    }

    @Test
    public void testFigureIRotationRight() {
        figureI.rotationRight();
        assertArrayEquals(new int[]{0,1,2,3},figureI.arrX);
        assertArrayEquals(new int[]{0,0,0,0},figureI.arrY);
    }

    @Test
    public void testFigureIRotationLeft() {
        figureI.rotationLeft();
        assertArrayEquals(new int[]{0,1,2,3},figureI.arrX);
        assertArrayEquals(new int[]{0,0,0,0},figureI.arrY);
    }

    @Test
    public void testFigureIRotationRight2() {
        figureI.rotationRight();
        figureI.rotationRight();
        assertArrayEquals(new int[]{0,0,0,0},figureI.arrX);
        assertArrayEquals(new int[]{0,1,2,3},figureI.arrY);
    }

    @Test
    public void testFigureIRotationLeft2() {
        figureI.rotationLeft();
        figureI.rotationLeft();
        assertArrayEquals(new int[]{0,0,0,0},figureI.arrX);
        assertArrayEquals(new int[]{0,1,2,3},figureI.arrY);
    }

    @Test
    public void testFigureIRightLeft() {
        figureI.rotationRight();
        figureI.rotationLeft();
        assertArrayEquals(new int[]{0,0,0,0},figureI.arrX);
        assertArrayEquals(new int[]{0,1,2,3},figureI.arrY);
    }

    @Test
    public void testFigureILeftRight() {
        figureI.rotationLeft();
        figureI.rotationRight();
        assertArrayEquals(new int[]{0,0,0,0},figureI.arrX);
        assertArrayEquals(new int[]{0,1,2,3},figureI.arrY);
    }

    @Test
    public void testFigureIGetGridVal() {
        Assertions.assertEquals(Figure.I, figureI.getGridVal());
    }

    @Test
    public void testFigureIGetColor() {
        assertEquals(Figure.COL_I, figureI.getColor());
    }
}
