package com.devng.jetris;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FiguresTest {
    private FigureI figureI;
    private FigureJ figureJ;
    private FigureL figureL;
    private FigureO figureO;
    private FigureS figureS;
    private FigureT figureT;
    private FigureZ figureZ;

    @BeforeEach
    public void setup() {
        figureI = new FigureI();
        figureJ = new FigureJ();
        figureL = new FigureL();
        figureO = new FigureO();
        figureS = new FigureS();
        figureT = new FigureT();
        figureZ = new FigureZ();
    }

    @Test
    @Tag("FigureI")
    public void testFigureIGetMaxRightOffset() {
        assertEquals(4,figureI.getMaxRightOffset());
    }

    @Test
    @Tag("FigureI")
    public void testFigureIResetOffset() {
        figureI.resetOffsets();
        assertEquals(0, figureI.offsetX);
        assertEquals(0, figureI.offsetY);
        assertEquals(0, figureI.offsetXLast);
        assertEquals(0, figureI.offsetYLast);
    }

    // Probably shouldn't have negative values? Check during integration test
    @Test
    @Tag("FigureI")
    public void testFigureISetOffset() {
        figureI.setOffset(10,2);
        figureI.setOffset(-2,10);
        assertEquals(-2, figureI.offsetX);
        assertEquals(10, figureI.offsetY);
        assertEquals(10, figureI.offsetXLast);
        assertEquals(2, figureI.offsetYLast);
    }

    @Test
    @Tag("FigureI")
    public void testFigureIResetOffsetGetMaxRightOffset() {
        figureI.resetOffsets();
        assertEquals(0, figureI.getMaxRightOffset());
    }

    @Test
    @Tag("FigureI")
    public void testFigureISetOffsetGetMaxRightOffset() {
        figureI.setOffset(4,7);
        assertEquals(4, figureI.getMaxRightOffset());
    }

    @Test
    @Tag("FigureI")
    public void testFigureIRotationRight() {
        figureI.rotationRight();
        assertArrayEquals(new int[]{0,1,2,3},figureI.arrX);
        assertArrayEquals(new int[]{0,0,0,0},figureI.arrY);
    }

    @Test
    @Tag("FigureI")
    public void testFigureIRotationLeft() {
        figureI.rotationLeft();
        assertArrayEquals(new int[]{0,1,2,3},figureI.arrX);
        assertArrayEquals(new int[]{0,0,0,0},figureI.arrY);
    }

    @Test
    @Tag("FigureI")
    public void testFigureIRotationRight2() {
        figureI.rotationRight();
        figureI.rotationRight();
        assertArrayEquals(new int[]{0,0,0,0},figureI.arrX);
        assertArrayEquals(new int[]{0,1,2,3},figureI.arrY);
    }

    @Test
    @Tag("FigureI")
    public void testFigureIRotationLeft2() {
        figureI.rotationLeft();
        figureI.rotationLeft();
        assertArrayEquals(new int[]{0,0,0,0},figureI.arrX);
        assertArrayEquals(new int[]{0,1,2,3},figureI.arrY);
    }

    @Test
    @Tag("FigureI")
    public void testFigureIRightLeft() {
        figureI.rotationRight();
        figureI.rotationLeft();
        assertArrayEquals(new int[]{0,0,0,0},figureI.arrX);
        assertArrayEquals(new int[]{0,1,2,3},figureI.arrY);
    }

    @Test
    @Tag("FigureI")
    public void testFigureILeftRight() {
        figureI.rotationLeft();
        figureI.rotationRight();
        assertArrayEquals(new int[]{0,0,0,0},figureI.arrX);
        assertArrayEquals(new int[]{0,1,2,3},figureI.arrY);
    }

    @Test
    @Tag("FigureI")
    public void testFigureIGetGridVal() {
        assertEquals(Figure.I, figureI.getGridVal());
    }

    @Test
    @Tag("FigureI")
    public void testFigureIGetColor() {
        assertEquals(Figure.COL_I, figureI.getColor());
    }

    @Test
    @Tag("FigureJ")
    public void testFigureJResetOffset() {
        figureJ.resetOffsets();
        assertEquals(0, figureJ.offsetX);
        assertEquals(0, figureJ.offsetY);
        assertEquals(0, figureJ.offsetXLast);
        assertEquals(0, figureJ.offsetYLast);
    }

    @Test
    @Tag("FigureJ")
    public void testFigureJSetOffset() {
        figureJ.setOffset(1,-1);
        figureJ.setOffset(0,9);
        assertEquals(0, figureJ.offsetX);
        assertEquals(9, figureJ.offsetY);
        assertEquals(1, figureJ.offsetXLast);
        assertEquals(-1, figureJ.offsetYLast);
    }

    @Test
    @Tag("FigureJ")
    public void testFigureJGetMaxRightOffset() {
        assertEquals(5,figureJ.getMaxRightOffset());
    }

    @Test
    @Tag("FigureJ")
    public void testFigureJResetOffsetGetMaxRightOffset() {
        figureJ.resetOffsets();
        assertEquals(1, figureJ.getMaxRightOffset());
    }

    @Test
    @Tag("FigureJ")
    public void testFigureJSetOffsetGetMaxRightOffset() {
        figureJ.setOffset(4,-2);
        assertEquals(5, figureJ.getMaxRightOffset());
    }

    @Test
    @Tag("FigureJ")
    public void testFigureJRotationRight() {
        figureJ.rotationRight();
        assertArrayEquals(new int[]{0,0,1,2},figureJ.arrX);
        assertArrayEquals(new int[]{0,1,1,1},figureJ.arrY);
    }

    @Test
    @Tag("FigureJ")
    public void testFigureJRotationRight2() {
        figureJ.rotationRight();
        figureJ.rotationRight();
        assertArrayEquals(new int[]{0,0,0,1},figureJ.arrX);
        assertArrayEquals(new int[]{0,1,2,0},figureJ.arrY);
    }

    @Test
    @Tag("FigureJ")
    public void testFigureJRotationRight3() {
        figureJ.rotationRight();
        figureJ.rotationRight();
        figureJ.rotationRight();
        assertArrayEquals(new int[]{0,1,2,2},figureJ.arrX);
        assertArrayEquals(new int[]{0,0,0,1},figureJ.arrY);
    }

    @Test
    @Tag("FigureJ")
    public void testFigureJRotationRight4() {
        figureJ.rotationRight();
        figureJ.rotationRight();
        figureJ.rotationRight();
        figureJ.rotationRight();
        assertArrayEquals(new int[]{0,1,1,1},figureJ.arrX);
        assertArrayEquals(new int[]{2,0,1,2},figureJ.arrY);
    }

    @Test
    @Tag("FigureJ")
    public void testFigureJRotationLeft() {
        figureJ.rotationLeft();
        assertArrayEquals(new int[]{0,1,2,2},figureJ.arrX);
        assertArrayEquals(new int[]{0,0,0,1},figureJ.arrY);
    }

    @Test
    @Tag("FigureJ")
    public void testFigureJRotationLeft2() {
        figureJ.rotationLeft();
        figureJ.rotationLeft();
        assertArrayEquals(new int[]{0,0,0,1},figureJ.arrX);
        assertArrayEquals(new int[]{0,1,2,0},figureJ.arrY);
    }

    @Test
    @Tag("FigureJ")
    public void testFigureJRotationLeft3() {
        figureJ.rotationLeft();
        figureJ.rotationLeft();
        figureJ.rotationLeft();
        assertArrayEquals(new int[]{0,0,1,2},figureJ.arrX);
        assertArrayEquals(new int[]{0,1,1,1},figureJ.arrY);
    }

    @Test
    @Tag("FigureJ")
    public void testFigureJRotationLeft4() {
        figureJ.rotationLeft();
        figureJ.rotationLeft();
        figureJ.rotationLeft();
        figureJ.rotationLeft();
        assertArrayEquals(new int[]{0,1,1,1},figureJ.arrX);
        assertArrayEquals(new int[]{2,0,1,2},figureJ.arrY);
    }

    @Test
    @Tag("FigureJ")
    public void testFigureJRightLeft() {
        figureJ.rotationRight();
        figureJ.rotationLeft();
        assertArrayEquals(new int[]{0,1,1,1},figureJ.arrX);
        assertArrayEquals(new int[]{2,0,1,2},figureJ.arrY);
    }

    @Test
    @Tag("FigureJ")
    public void testFigureJLeftRight() {
        figureJ.rotationLeft();
        figureJ.rotationRight();
        assertArrayEquals(new int[]{0,1,1,1},figureJ.arrX);
        assertArrayEquals(new int[]{2,0,1,2},figureJ.arrY);
    }

    @Test
    @Tag("FigureJ")
    public void testFigureJGetGridVal() {
        assertEquals(Figure.J, figureJ.getGridVal());
    }

    @Test
    @Tag("FigureJ")
    public void testFigureJGetColor() {
        assertEquals(Figure.COL_J, figureJ.getColor());
    }
}
