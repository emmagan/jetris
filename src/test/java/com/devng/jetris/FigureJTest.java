package com.devng.jetris;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FigureJTest {
    private FigureJ figureJ;

    @BeforeEach
    public void setup() {
        figureJ = new FigureJ();
    }

    @Test
    public void testFigureJResetOffset() {
        figureJ.resetOffsets();
        assertEquals(0, figureJ.offsetX);
        assertEquals(0, figureJ.offsetY);
        assertEquals(0, figureJ.offsetXLast);
        assertEquals(0, figureJ.offsetYLast);
    }

    @Test
    public void testFigureJSetOffset() {
        figureJ.setOffset(1,-1);
        figureJ.setOffset(0,9);
        assertEquals(0, figureJ.offsetX);
        assertEquals(9, figureJ.offsetY);
        assertEquals(1, figureJ.offsetXLast);
        assertEquals(-1, figureJ.offsetYLast);
    }

    @Test
    public void testFigureJGetMaxRightOffset() {
        assertEquals(5,figureJ.getMaxRightOffset());
    }

    @Test
    public void testFigureJResetOffsetGetMaxRightOffset() {
        figureJ.resetOffsets();
        assertEquals(1, figureJ.getMaxRightOffset());
    }

    @Test
    public void testFigureJSetOffsetGetMaxRightOffset() {
        figureJ.setOffset(4,-2);
        assertEquals(5, figureJ.getMaxRightOffset());
    }

    @Test
    public void testFigureJRotationRight() {
        figureJ.rotationRight();
        assertArrayEquals(new int[]{0,0,1,2},figureJ.arrX);
        assertArrayEquals(new int[]{0,1,1,1},figureJ.arrY);
    }

    @Test
    public void testFigureJRotationRight2() {
        figureJ.rotationRight();
        figureJ.rotationRight();
        assertArrayEquals(new int[]{0,0,0,1},figureJ.arrX);
        assertArrayEquals(new int[]{0,1,2,0},figureJ.arrY);
    }

    @Test
    public void testFigureJRotationRight3() {
        figureJ.rotationRight();
        figureJ.rotationRight();
        figureJ.rotationRight();
        assertArrayEquals(new int[]{0,1,2,2},figureJ.arrX);
        assertArrayEquals(new int[]{0,0,0,1},figureJ.arrY);
    }

    @Test
    public void testFigureJRotationRight4() {
        figureJ.rotationRight();
        figureJ.rotationRight();
        figureJ.rotationRight();
        figureJ.rotationRight();
        assertArrayEquals(new int[]{0,1,1,1},figureJ.arrX);
        assertArrayEquals(new int[]{2,0,1,2},figureJ.arrY);
    }

    @Test
    public void testFigureJRotationLeft() {
        figureJ.rotationLeft();
        assertArrayEquals(new int[]{0,1,2,2},figureJ.arrX);
        assertArrayEquals(new int[]{0,0,0,1},figureJ.arrY);
    }

    @Test
    public void testFigureJRotationLeft2() {
        figureJ.rotationLeft();
        figureJ.rotationLeft();
        assertArrayEquals(new int[]{0,0,0,1},figureJ.arrX);
        assertArrayEquals(new int[]{0,1,2,0},figureJ.arrY);
    }

    @Test
    public void testFigureJRotationLeft3() {
        figureJ.rotationLeft();
        figureJ.rotationLeft();
        figureJ.rotationLeft();
        assertArrayEquals(new int[]{0,0,1,2},figureJ.arrX);
        assertArrayEquals(new int[]{0,1,1,1},figureJ.arrY);
    }

    @Test
    public void testFigureJRotationLeft4() {
        figureJ.rotationLeft();
        figureJ.rotationLeft();
        figureJ.rotationLeft();
        figureJ.rotationLeft();
        assertArrayEquals(new int[]{0,1,1,1},figureJ.arrX);
        assertArrayEquals(new int[]{2,0,1,2},figureJ.arrY);
    }

    @Test
    public void testFigureJRightLeft() {
        figureJ.rotationRight();
        figureJ.rotationLeft();
        assertArrayEquals(new int[]{0,1,1,1},figureJ.arrX);
        assertArrayEquals(new int[]{2,0,1,2},figureJ.arrY);
    }

    @Test
    public void testFigureJLeftRight() {
        figureJ.rotationLeft();
        figureJ.rotationRight();
        assertArrayEquals(new int[]{0,1,1,1},figureJ.arrX);
        assertArrayEquals(new int[]{2,0,1,2},figureJ.arrY);
    }

    @Test
    public void testFigureJGetGridVal() {
        Assertions.assertEquals(Figure.J, figureJ.getGridVal());
    }

    @Test
    public void testFigureJGetColor() {
        assertEquals(Figure.COL_J, figureJ.getColor());
    }
}
