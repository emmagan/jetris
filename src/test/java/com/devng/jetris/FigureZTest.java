package com.devng.jetris;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FigureZTest {
    private FigureZ figureZ;

    @BeforeEach
    public void setup() {
        figureZ = new FigureZ();
    }

    @Test
    public void testFigureZGetMaxRightOffset() {
        assertEquals(6,figureZ.getMaxRightOffset());
    }

    @Test
    public void testFigureZResetOffset() {
        figureZ.resetOffsets();
        assertEquals(0, figureZ.offsetX);
        assertEquals(0, figureZ.offsetY);
        assertEquals(0, figureZ.offsetXLast);
        assertEquals(0, figureZ.offsetYLast);
    }

    @Test
    public void testFigureZSetOffset() {
        figureZ.setOffset(1,7);
        figureZ.setOffset(3,0);
        figureZ.setOffset(-1,-2);
        assertEquals(-1, figureZ.offsetX);
        assertEquals(-2, figureZ.offsetY);
        assertEquals(3, figureZ.offsetXLast);
        assertEquals(0, figureZ.offsetYLast);
    }

    @Test
    public void testFigureZResetOffsetGetMaxRightOffset() {
        figureZ.resetOffsets();
        assertEquals(2, figureZ.getMaxRightOffset());
    }

    @Test
    public void testFigureZSetOffsetGetMaxRightOffset() {
        figureZ.setOffset(77,71);
        assertEquals(79, figureZ.getMaxRightOffset());
    }

    @Test
    public void testFigureZRotationRight() {
        figureZ.rotationRight();
        assertArrayEquals(new int[]{1,0,1,0},figureZ.arrX);
        assertArrayEquals(new int[]{0,1,1,2},figureZ.arrY);
    }

    @Test
    public void testFigureZRotationLeft() {
        figureZ.rotationLeft();
        assertArrayEquals(new int[]{1,0,1,0},figureZ.arrX);
        assertArrayEquals(new int[]{0,1,1,2},figureZ.arrY);
    }

    @Test
    public void testFigureZRotationRight2() {
        figureZ.rotationRight();
        figureZ.rotationRight();
        assertArrayEquals(new int[]{0,1,1,2},figureZ.arrX);
        assertArrayEquals(new int[]{0,0,1,1},figureZ.arrY);
    }

    @Test
    public void testFigureZRotationLeft2() {
        figureZ.rotationLeft();
        figureZ.rotationLeft();
        assertArrayEquals(new int[]{0,1,1,2},figureZ.arrX);
        assertArrayEquals(new int[]{0,0,1,1},figureZ.arrY);
    }

    @Test
    public void testFigureZRightLeft() {
        figureZ.rotationRight();
        figureZ.rotationLeft();
        assertArrayEquals(new int[]{0,1,1,2},figureZ.arrX);
        assertArrayEquals(new int[]{0,0,1,1},figureZ.arrY);
    }

    @Test
    public void testFigureZLeftRight() {
        figureZ.rotationLeft();
        figureZ.rotationRight();
        assertArrayEquals(new int[]{0,1,1,2},figureZ.arrX);
        assertArrayEquals(new int[]{0,0,1,1},figureZ.arrY);
    }

    @Test
    public void testFigureZGetGridVal() {
        Assertions.assertEquals(Figure.Z, figureZ.getGridVal());
    }

    @Test
    public void testFigureZGetColor() {
        assertEquals(Figure.COL_Z, figureZ.getColor());
    }
}
