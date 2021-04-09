package com.devng.jetris;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FigureTTest {
    private FigureT figureT;

    @BeforeEach
    public void setup() {
        figureT = new FigureT();
    }

    @Test
    public void testFigureTResetOffset() {
        figureT.resetOffsets();
        assertEquals(0, figureT.offsetX);
        assertEquals(0, figureT.offsetY);
        assertEquals(0, figureT.offsetXLast);
        assertEquals(0, figureT.offsetYLast);
    }

    @Test
    public void testFigureTSetOffset() {
        figureT.resetOffsets();
        figureT.setOffset(-1,-2);
        assertEquals(-1, figureT.offsetX);
        assertEquals(-2, figureT.offsetY);
        assertEquals(0, figureT.offsetXLast);
        assertEquals(0, figureT.offsetYLast);
    }

    @Test
    public void testFigureTGetMaxRightOffset() {
        assertEquals(6,figureT.getMaxRightOffset());
    }

    @Test
    public void testFigureTResetOffsetGetMaxRightOffset() {
        figureT.resetOffsets();
        assertEquals(2, figureT.getMaxRightOffset());
    }

    @Test
    public void testFigureTSetOffsetGetMaxRightOffset() {
        figureT.setOffset(100,100);
        assertEquals(102, figureT.getMaxRightOffset());
    }

    @Test
    public void testFigureTRotationRight() {
        figureT.rotationRight();
        assertArrayEquals(new int[]{0,1,1,1},figureT.arrX);
        assertArrayEquals(new int[]{1,0,1,2},figureT.arrY);
    }

    @Test
    public void testFigureTRotationRight2() {
        figureT.rotationRight();
        figureT.rotationRight();
        assertArrayEquals(new int[]{0,1,1,2},figureT.arrX);
        assertArrayEquals(new int[]{1,0,1,1},figureT.arrY);
    }

    @Test
    public void testFigureTRotationRight3() {
        figureT.rotationRight();
        figureT.rotationRight();
        figureT.rotationRight();
        assertArrayEquals(new int[]{0,0,0,1},figureT.arrX);
        assertArrayEquals(new int[]{0,1,2,1},figureT.arrY);
    }

    @Test
    public void testFigureTRotationRight4() {
        figureT.rotationRight();
        figureT.rotationRight();
        figureT.rotationRight();
        figureT.rotationRight();
        assertArrayEquals(new int[]{0,1,1,2},figureT.arrX);
        assertArrayEquals(new int[]{0,0,1,0},figureT.arrY);
    }

    @Test
    public void testFigureTRotationLeft() {
        figureT.rotationLeft();
        assertArrayEquals(new int[]{0,0,0,1},figureT.arrX);
        assertArrayEquals(new int[]{0,1,2,1},figureT.arrY);
    }

    @Test
    public void testFigureTRotationLeft2() {
        figureT.rotationLeft();
        figureT.rotationLeft();
        assertArrayEquals(new int[]{0,1,1,2},figureT.arrX);
        assertArrayEquals(new int[]{1,0,1,1},figureT.arrY);
    }

    @Test
    public void testFigureTRotationLeft3() {
        figureT.rotationLeft();
        figureT.rotationLeft();
        figureT.rotationLeft();
        assertArrayEquals(new int[]{0,1,1,1},figureT.arrX);
        assertArrayEquals(new int[]{1,0,1,2},figureT.arrY);
    }

    @Test
    public void testFigureTRotationLeft4() {
        figureT.rotationLeft();
        figureT.rotationLeft();
        figureT.rotationLeft();
        figureT.rotationLeft();
        assertArrayEquals(new int[]{0,1,1,2},figureT.arrX);
        assertArrayEquals(new int[]{0,0,1,0},figureT.arrY);
    }

    @Test
    public void testFigureTRightLeft() {
        figureT.rotationRight();
        figureT.rotationLeft();
        assertArrayEquals(new int[]{0,1,1,2},figureT.arrX);
        assertArrayEquals(new int[]{0,0,1,0},figureT.arrY);
    }

    @Test
    public void testFigureTLeftRight() {
        figureT.rotationLeft();
        figureT.rotationRight();
        assertArrayEquals(new int[]{0,1,1,2},figureT.arrX);
        assertArrayEquals(new int[]{0,0,1,0},figureT.arrY);
    }

    @Test
    public void testFigureTGetGridVal() {
        assertEquals(Figure.T, figureT.getGridVal());
    }

    @Test
    public void testFigureTGetColor() {
        assertEquals(Figure.COL_T, figureT.getColor());
    }
}
