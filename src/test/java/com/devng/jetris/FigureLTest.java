package com.devng.jetris;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FigureLTest {
    private FigureL figureL;

    @BeforeEach
    public void setup() {
        figureL = new FigureL();
    }

    @Test
    public void testFigureLResetOffset() {
        figureL.resetOffsets();
        assertEquals(0, figureL.offsetX);
        assertEquals(0, figureL.offsetY);
        assertEquals(0, figureL.offsetXLast);
        assertEquals(0, figureL.offsetYLast);
    }

    @Test
    public void testFigureLSetOffset() {
        figureL.setOffset(Integer.MIN_VALUE,0);
        figureL.setOffset(Integer.MAX_VALUE,Integer.MIN_VALUE);
        assertEquals(Integer.MAX_VALUE, figureL.offsetX);
        assertEquals(Integer.MIN_VALUE, figureL.offsetY);
        assertEquals(Integer.MIN_VALUE, figureL.offsetXLast);
        assertEquals(0, figureL.offsetYLast);
    }

    @Test
    public void testFigureLGetMaxRightOffset() {
        assertEquals(5,figureL.getMaxRightOffset());
    }

    @Test
    public void testFigureLResetOffsetGetMaxRightOffset() {
        figureL.resetOffsets();
        assertEquals(1, figureL.getMaxRightOffset());
    }

    @Test
    public void testFigureLSetOffsetGetMaxRightOffset() {
        figureL.setOffset(9,-2);
        assertEquals(10, figureL.getMaxRightOffset());
    }

    @Test
    public void testFigureLRotationRight() {
        figureL.rotationRight();
        assertArrayEquals(new int[]{0,0,1,2},figureL.arrX);
        assertArrayEquals(new int[]{0,1,0,0},figureL.arrY);
    }

    @Test
    public void testFigureLRotationRight2() {
        figureL.rotationRight();
        figureL.rotationRight();
        assertArrayEquals(new int[]{0,1,1,1},figureL.arrX);
        assertArrayEquals(new int[]{0,0,1,2},figureL.arrY);
    }

    @Test
    public void testFigureLRotationRight3() {
        figureL.rotationRight();
        figureL.rotationRight();
        figureL.rotationRight();
        assertArrayEquals(new int[]{0,1,2,2},figureL.arrX);
        assertArrayEquals(new int[]{1,1,0,1},figureL.arrY);
    }

    @Test
    public void testFigureLRotationRight4() {
        figureL.rotationRight();
        figureL.rotationRight();
        figureL.rotationRight();
        figureL.rotationRight();
        assertArrayEquals(new int[]{0,0,0,1},figureL.arrX);
        assertArrayEquals(new int[]{0,1,2,2},figureL.arrY);
    }

    @Test
    public void testFigureLRotationLeft() {
        figureL.rotationLeft();
        assertArrayEquals(new int[]{0,1,2,2},figureL.arrX);
        assertArrayEquals(new int[]{1,1,0,1},figureL.arrY);
    }

    @Test
    public void testFigureLRotationLeft2() {
        figureL.rotationLeft();
        figureL.rotationLeft();
        assertArrayEquals(new int[]{0,1,1,1},figureL.arrX);
        assertArrayEquals(new int[]{0,0,1,2},figureL.arrY);
    }

    @Test
    public void testFigureLRotationLeft3() {
        figureL.rotationLeft();
        figureL.rotationLeft();
        figureL.rotationLeft();
        assertArrayEquals(new int[]{0,0,1,2},figureL.arrX);
        assertArrayEquals(new int[]{0,1,0,0},figureL.arrY);
    }

    @Test
    public void testFigureLRotationLeft4() {
        figureL.rotationLeft();
        figureL.rotationLeft();
        figureL.rotationLeft();
        figureL.rotationLeft();
        assertArrayEquals(new int[]{0,0,0,1},figureL.arrX);
        assertArrayEquals(new int[]{0,1,2,2},figureL.arrY);
    }

    @Test
    public void testFigureLRightLeft() {
        figureL.rotationRight();
        figureL.rotationLeft();
        assertArrayEquals(new int[]{0,0,0,1},figureL.arrX);
        assertArrayEquals(new int[]{0,1,2,2},figureL.arrY);
    }

    @Test
    public void testFigureLLeftRight() {
        figureL.rotationLeft();
        figureL.rotationRight();
        assertArrayEquals(new int[]{0,0,0,1},figureL.arrX);
        assertArrayEquals(new int[]{0,1,2,2},figureL.arrY);
    }

    @Test
    public void testFigureLGetGridVal() {
        Assertions.assertEquals(Figure.L, figureL.getGridVal());
    }

    @Test
    public void testFigureLGetColor() {
        assertEquals(Figure.COL_L, figureL.getColor());
    }
}
