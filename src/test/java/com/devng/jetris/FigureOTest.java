package com.devng.jetris;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FigureOTest {
    private FigureO figureO;

    @BeforeEach
    public void setup() {
        figureO = new FigureO();
    }

    @Test
    public void testFigureOResetOffset() {
        figureO.resetOffsets();
        assertEquals(0, figureO.offsetX);
        assertEquals(0, figureO.offsetY);
        assertEquals(0, figureO.offsetXLast);
        assertEquals(0, figureO.offsetYLast);
    }

    @Test
    public void testFigureOSetOffset() {
        figureO.setOffset(Integer.MAX_VALUE,Integer.MIN_VALUE);
        assertEquals(Integer.MAX_VALUE, figureO.offsetX);
        assertEquals(Integer.MIN_VALUE, figureO.offsetY);
        assertEquals(4, figureO.offsetXLast);
        assertEquals(0, figureO.offsetYLast);
    }

    @Test
    public void testFigureOGetMaxRightOffset() {
        assertEquals(5,figureO.getMaxRightOffset());
    }

    @Test
    public void testFigureOResetOffsetGetMaxRightOffset() {
        figureO.resetOffsets();
        assertEquals(1, figureO.getMaxRightOffset());
    }

    @Test
    public void testFigureOSetOffsetGetMaxRightOffset() {
        figureO.setOffset(9,-2);
        assertEquals(10, figureO.getMaxRightOffset());
    }

    @Test
    public void testFigureORotationRight() {
        figureO.rotationRight();
        assertArrayEquals(new int[]{0,0,1,1},figureO.arrX);
        assertArrayEquals(new int[]{0,1,0,1},figureO.arrY);
    }

    @Test
    public void testFigureORotationLeft() {
        figureO.rotationLeft();
        assertArrayEquals(new int[]{0,0,1,1},figureO.arrX);
        assertArrayEquals(new int[]{0,1,0,1},figureO.arrY);
    }


    @Test
    public void testFigureOGetGridVal() {
        assertEquals(Figure.O, figureO.getGridVal());
    }

    @Test
    public void testFigureOGetColor() {
        assertEquals(Figure.COL_O, figureO.getColor());
    }
}
