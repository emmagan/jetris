package com.devng.jetris;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FigureFactoryTest {
    private FigureFactory figureFactory;
    private Random r;

    @BeforeEach
    public void setup() {
        r = mock(Random.class);
        figureFactory = new FigureFactory(r);
    }

    @Test
    public void testGetCounts() {
        assertArrayEquals(new int[]{0,0,0,0,0,0,0}, figureFactory.getCounts());
    }

    @Test
    public void testResetCountsInitially() {
        figureFactory.resetCounts();
        assertArrayEquals(new int[]{0,0,0,0,0,0,0}, figureFactory.getCounts());
    }

    @Test
    public void testResetCounts() {
        figureFactory.getRandomFigure();
        assertFalse(Arrays.equals(new int[]{0,0,0,0,0,0,0}, figureFactory.getCounts()));
        figureFactory.resetCounts();
        assertArrayEquals(new int[]{0,0,0,0,0,0,0}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigureI() {
        when(r.nextInt(7)).thenReturn(0);
        when(r.nextInt(4)).thenReturn(0);

        Figure f = figureFactory.getRandomFigure();
        assertEquals(Figure.I, f.getGridVal());
        assertArrayEquals(new int[]{0, 0, 0, 0}, f.arrX);
        assertArrayEquals(new int[]{0, 1, 2, 3}, f.arrY);
        assertArrayEquals(new int[]{1,0,0,0,0,0,0}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigureIRotate1() {
        when(r.nextInt(7)).thenReturn(0);
        when(r.nextInt(4)).thenReturn(1);

        Figure f = figureFactory.getRandomFigure();
        assertEquals(Figure.I, f.getGridVal());
        assertArrayEquals(new int[]{0, 0, 0, 0}, f.arrY);
        assertArrayEquals(new int[]{0, 1, 2, 3}, f.arrX);
        assertArrayEquals(new int[]{1,0,0,0,0,0,0}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigureIRotate2() {
        when(r.nextInt(7)).thenReturn(0);
        when(r.nextInt(4)).thenReturn(2);

        Figure f = figureFactory.getRandomFigure();
        assertEquals(Figure.I, f.getGridVal());
        assertArrayEquals(new int[]{0, 0, 0, 0}, f.arrX);
        assertArrayEquals(new int[]{0, 1, 2, 3}, f.arrY);
        assertArrayEquals(new int[]{1,0,0,0,0,0,0}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigureIRotate3() {
        when(r.nextInt(7)).thenReturn(0);
        when(r.nextInt(4)).thenReturn(3);

        Figure f = figureFactory.getRandomFigure();
        assertEquals(Figure.I, f.getGridVal());
        assertArrayEquals(new int[]{0, 0, 0, 0}, f.arrY);
        assertArrayEquals(new int[]{0, 1, 2, 3}, f.arrX);
        assertArrayEquals(new int[]{1,0,0,0,0,0,0}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigureT() {
        when(r.nextInt(7)).thenReturn(1);
        when(r.nextInt(4)).thenReturn(0);

        Figure f = figureFactory.getRandomFigure();
        assertEquals(Figure.T, f.getGridVal());
        assertArrayEquals(new int[]{0, 1, 1, 2}, f.arrX);
        assertArrayEquals(new int[]{0, 0, 1, 0}, f.arrY);
        assertArrayEquals(new int[]{0,1,0,0,0,0,0}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigureTRotate1() {
        when(r.nextInt(7)).thenReturn(1);
        when(r.nextInt(4)).thenReturn(1);

        Figure f = figureFactory.getRandomFigure();
        assertEquals(Figure.T, f.getGridVal());
        assertArrayEquals(new int[]{0, 1, 1, 1}, f.arrX);
        assertArrayEquals(new int[]{1, 0, 1, 2}, f.arrY);
        assertArrayEquals(new int[]{0,1,0,0,0,0,0}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigureTRotate2() {
        when(r.nextInt(7)).thenReturn(1);
        when(r.nextInt(4)).thenReturn(2);

        Figure f = figureFactory.getRandomFigure();
        assertEquals(Figure.T, f.getGridVal());
        assertArrayEquals(new int[]{0, 1, 1, 2}, f.arrX);
        assertArrayEquals(new int[]{1, 0, 1, 1}, f.arrY);
        assertArrayEquals(new int[]{0,1,0,0,0,0,0}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigureTRotate3() {
        when(r.nextInt(7)).thenReturn(1);
        when(r.nextInt(4)).thenReturn(3);

        Figure f = figureFactory.getRandomFigure();
        assertEquals(Figure.T, f.getGridVal());
        assertArrayEquals(new int[]{0, 0, 0, 1}, f.arrX);
        assertArrayEquals(new int[]{0, 1, 2, 1}, f.arrY);
        assertArrayEquals(new int[]{0,1,0,0,0,0,0}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigureO() {
        when(r.nextInt(7)).thenReturn(2);
        when(r.nextInt(4)).thenReturn(0);

        Figure f = figureFactory.getRandomFigure();
        assertEquals(Figure.O, f.getGridVal());
        assertArrayEquals(new int[]{0, 0, 1, 1}, f.arrX);
        assertArrayEquals(new int[]{0, 1, 0, 1}, f.arrY);
        assertArrayEquals(new int[]{0,0,1,0,0,0,0}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigureORotate1() {
        when(r.nextInt(7)).thenReturn(2);
        when(r.nextInt(4)).thenReturn(1);

        Figure f = figureFactory.getRandomFigure();
        assertEquals(Figure.O, f.getGridVal());
        assertArrayEquals(new int[]{0, 0, 1, 1}, f.arrX);
        assertArrayEquals(new int[]{0, 1, 0, 1}, f.arrY);
        assertArrayEquals(new int[]{0,0,1,0,0,0,0}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigureORotate2() {
        when(r.nextInt(7)).thenReturn(2);
        when(r.nextInt(4)).thenReturn(2);

        Figure f = figureFactory.getRandomFigure();
        assertEquals(Figure.O, f.getGridVal());
        assertArrayEquals(new int[]{0, 0, 1, 1}, f.arrX);
        assertArrayEquals(new int[]{0, 1, 0, 1}, f.arrY);
        assertArrayEquals(new int[]{0,0,1,0,0,0,0}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigureORotate3() {
        when(r.nextInt(7)).thenReturn(2);
        when(r.nextInt(4)).thenReturn(3);

        Figure f = figureFactory.getRandomFigure();
        assertEquals(Figure.O, f.getGridVal());
        assertArrayEquals(new int[]{0, 0, 1, 1}, f.arrX);
        assertArrayEquals(new int[]{0, 1, 0, 1}, f.arrY);
        assertArrayEquals(new int[]{0,0,1,0,0,0,0}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigureL() {
        when(r.nextInt(7)).thenReturn(3);
        when(r.nextInt(4)).thenReturn(0);

        Figure f = figureFactory.getRandomFigure();
        assertEquals(Figure.L, f.getGridVal());
        assertArrayEquals(new int[]{0, 0, 0, 1}, f.arrX);
        assertArrayEquals(new int[]{0, 1, 2, 2}, f.arrY);
        assertArrayEquals(new int[]{0,0,0,1,0,0,0}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigureLRotate1() {
        when(r.nextInt(7)).thenReturn(3);
        when(r.nextInt(4)).thenReturn(1);

        Figure f = figureFactory.getRandomFigure();
        assertEquals(Figure.L, f.getGridVal());
        assertArrayEquals(new int[]{0, 0, 1, 2}, f.arrX);
        assertArrayEquals(new int[]{0, 1, 0, 0}, f.arrY);
        assertArrayEquals(new int[]{0,0,0,1,0,0,0}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigureLRotate2() {
        when(r.nextInt(7)).thenReturn(3);
        when(r.nextInt(4)).thenReturn(2);

        Figure f = figureFactory.getRandomFigure();
        assertEquals(Figure.L, f.getGridVal());
        assertArrayEquals(new int[]{0, 1, 1, 1}, f.arrX);
        assertArrayEquals(new int[]{0, 0, 1, 2}, f.arrY);
        assertArrayEquals(new int[]{0,0,0,1,0,0,0}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigureLRotate3() {
        when(r.nextInt(7)).thenReturn(3);
        when(r.nextInt(4)).thenReturn(3);

        Figure f = figureFactory.getRandomFigure();
        assertEquals(Figure.L, f.getGridVal());
        assertArrayEquals(new int[]{0, 1, 2, 2}, f.arrX);
        assertArrayEquals(new int[]{1, 1, 0, 1}, f.arrY);
        assertArrayEquals(new int[]{0,0,0,1,0,0,0}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigureJ() {
        when(r.nextInt(7)).thenReturn(4);
        when(r.nextInt(4)).thenReturn(0);

        Figure f = figureFactory.getRandomFigure();
        assertEquals(Figure.J, f.getGridVal());
        assertArrayEquals(new int[]{0, 1, 1, 1}, f.arrX);
        assertArrayEquals(new int[]{2, 0, 1, 2}, f.arrY);
        assertArrayEquals(new int[]{0,0,0,0,1,0,0}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigureJRotate1() {
        when(r.nextInt(7)).thenReturn(4);
        when(r.nextInt(4)).thenReturn(1);

        Figure f = figureFactory.getRandomFigure();
        assertEquals(Figure.J, f.getGridVal());
        assertArrayEquals(new int[]{0, 0, 1, 2}, f.arrX);
        assertArrayEquals(new int[]{0, 1, 1, 1}, f.arrY);
        assertArrayEquals(new int[]{0,0,0,0,1,0,0}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigureJRotate2() {
        when(r.nextInt(7)).thenReturn(4);
        when(r.nextInt(4)).thenReturn(2);

        Figure f = figureFactory.getRandomFigure();
        assertEquals(Figure.J, f.getGridVal());
        assertArrayEquals(new int[]{0, 0, 0, 1}, f.arrX);
        assertArrayEquals(new int[]{0, 1, 2, 0}, f.arrY);
        assertArrayEquals(new int[]{0,0,0,0,1,0,0}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigureJRotate3() {
        when(r.nextInt(7)).thenReturn(4);
        when(r.nextInt(4)).thenReturn(3);

        Figure f = figureFactory.getRandomFigure();
        assertEquals(Figure.J, f.getGridVal());
        assertArrayEquals(new int[]{0, 1, 2, 2}, f.arrX);
        assertArrayEquals(new int[]{0, 0, 0, 1}, f.arrY);
        assertArrayEquals(new int[]{0,0,0,0,1,0,0}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigureS() {
        when(r.nextInt(7)).thenReturn(5);
        when(r.nextInt(4)).thenReturn(0);

        Figure f = figureFactory.getRandomFigure();
        assertEquals(Figure.S, f.getGridVal());
        assertArrayEquals(new int[]{0, 1, 1, 2}, f.arrX);
        assertArrayEquals(new int[]{1, 0, 1, 0}, f.arrY);
        assertArrayEquals(new int[]{0,0,0,0,0,1,0}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigureSRotate1() {
        when(r.nextInt(7)).thenReturn(5);
        when(r.nextInt(4)).thenReturn(1);

        Figure f = figureFactory.getRandomFigure();
        assertEquals(Figure.S, f.getGridVal());
        assertArrayEquals(new int[]{0, 1, 1, 2}, f.arrY);
        assertArrayEquals(new int[]{0, 0, 1, 1}, f.arrX);
        assertArrayEquals(new int[]{0,0,0,0,0,1,0}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigureSRotate2() {
        when(r.nextInt(7)).thenReturn(5);
        when(r.nextInt(4)).thenReturn(2);

        Figure f = figureFactory.getRandomFigure();
        assertEquals(Figure.S, f.getGridVal());
        assertArrayEquals(new int[]{0, 1, 1, 2}, f.arrX);
        assertArrayEquals(new int[]{1, 0, 1, 0}, f.arrY);
        assertArrayEquals(new int[]{0,0,0,0,0,1,0}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigureSRotate3() {
        when(r.nextInt(7)).thenReturn(5);
        when(r.nextInt(4)).thenReturn(3);

        Figure f = figureFactory.getRandomFigure();
        assertEquals(Figure.S, f.getGridVal());
        assertArrayEquals(new int[]{0, 1, 1, 2}, f.arrY);
        assertArrayEquals(new int[]{0, 0, 1, 1}, f.arrX);
        assertArrayEquals(new int[]{0,0,0,0,0,1,0}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigureZ() {
        when(r.nextInt(7)).thenReturn(6);
        when(r.nextInt(4)).thenReturn(0);

        Figure f = figureFactory.getRandomFigure();
        assertEquals(Figure.Z, f.getGridVal());
        assertArrayEquals(new int[]{0, 1, 1, 2}, f.arrX);
        assertArrayEquals(new int[]{0, 0, 1, 1}, f.arrY);
        assertArrayEquals(new int[]{0,0,0,0,0,0,1}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigureZRotate1() {
        when(r.nextInt(7)).thenReturn(6);
        when(r.nextInt(4)).thenReturn(1);

        Figure f = figureFactory.getRandomFigure();
        assertEquals(Figure.Z, f.getGridVal());
        assertArrayEquals(new int[]{0, 1, 1, 2}, f.arrY);
        assertArrayEquals(new int[]{1, 0, 1, 0}, f.arrX);
        assertArrayEquals(new int[]{0,0,0,0,0,0,1}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigureZRotate2() {
        when(r.nextInt(7)).thenReturn(6);
        when(r.nextInt(4)).thenReturn(2);

        Figure f = figureFactory.getRandomFigure();
        assertEquals(Figure.Z, f.getGridVal());
        assertArrayEquals(new int[]{0, 1, 1, 2}, f.arrX);
        assertArrayEquals(new int[]{0, 0, 1, 1}, f.arrY);
        assertArrayEquals(new int[]{0,0,0,0,0,0,1}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigureZRotate3() {
        when(r.nextInt(7)).thenReturn(6);
        when(r.nextInt(4)).thenReturn(3);

        Figure f = figureFactory.getRandomFigure();
        assertEquals(Figure.Z, f.getGridVal());
        assertArrayEquals(new int[]{0, 1, 1, 2}, f.arrY);
        assertArrayEquals(new int[]{1, 0, 1, 0}, f.arrX);
        assertArrayEquals(new int[]{0,0,0,0,0,0,1}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigure2RepeatsFirstPosition() {
        when(r.nextInt(7)).thenReturn(0,0,1);
        when(r.nextInt(4)).thenReturn(0,1);

        Figure f1 = figureFactory.getRandomFigure();
        Figure f2 = figureFactory.getRandomFigure();

        assertEquals(Figure.I, f1.getGridVal());
        assertEquals(Figure.I, f2.getGridVal());
        assertArrayEquals(new int[]{2,0,0,0,0,0,0}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigure2RepeatsMiddlePosition() {
        when(r.nextInt(7)).thenReturn(0,1,1,0);
        when(r.nextInt(4)).thenReturn(0,1,2);

        Figure f1 = figureFactory.getRandomFigure();
        Figure f2 = figureFactory.getRandomFigure();
        Figure f3 = figureFactory.getRandomFigure();

        assertEquals(Figure.I, f1.getGridVal());
        assertEquals(Figure.T, f2.getGridVal());
        assertEquals(Figure.T, f3.getGridVal());
        assertArrayEquals(new int[]{1,2,0,0,0,0,0}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigure3RepeatsFirstPosition() {
        when(r.nextInt(7)).thenReturn(0,0,0,1);
        when(r.nextInt(4)).thenReturn(0,1,2);

        Figure f1 = figureFactory.getRandomFigure();
        Figure f2 = figureFactory.getRandomFigure();
        Figure f3 = figureFactory.getRandomFigure();

        assertEquals(Figure.I, f1.getGridVal());
        assertEquals(Figure.I, f2.getGridVal());
        assertEquals(Figure.T, f3.getGridVal());
        assertArrayEquals(new int[]{2,1,0,0,0,0,0}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigure3RepeatsMiddlePosition() {
        when(r.nextInt(7)).thenReturn(0,0,0,0,0,0,0,1);
        when(r.nextInt(4)).thenReturn(0,1,2);

        Figure f1 = figureFactory.getRandomFigure();
        Figure f2 = figureFactory.getRandomFigure();
        Figure f3 = figureFactory.getRandomFigure();

        assertEquals(Figure.I, f1.getGridVal());
        assertEquals(Figure.I, f2.getGridVal());
        assertEquals(Figure.T, f3.getGridVal());
        assertArrayEquals(new int[]{2,1,0,0,0,0,0}, figureFactory.getCounts());
    }


    @Test
    public void testGetRandomFigureMultiple3Repeats() {
        when(r.nextInt(7)).thenReturn(0,0,0,0,0,1,1,1,1,2);
        when(r.nextInt(4)).thenReturn(0,1,2,3,1);

        Figure f1 = figureFactory.getRandomFigure();
        Figure f2 = figureFactory.getRandomFigure();
        Figure f3 = figureFactory.getRandomFigure();
        Figure f4 = figureFactory.getRandomFigure();
        Figure f5 = figureFactory.getRandomFigure();

        assertEquals(Figure.I, f1.getGridVal());
        assertEquals(Figure.I, f2.getGridVal());
        assertEquals(Figure.T, f3.getGridVal());
        assertEquals(Figure.T, f4.getGridVal());
        assertEquals(Figure.O, f5.getGridVal());
        assertArrayEquals(new int[]{2,2,1,0,0,0,0}, figureFactory.getCounts());
    }

    @Test
    public void testGetRandomFigure3RepeatsBrokenUp() {
        when(r.nextInt(7)).thenReturn(4,4,4,3,3,4,4,4,3);
        when(r.nextInt(4)).thenReturn(0,1,2,3,1);

        Figure f1 = figureFactory.getRandomFigure();
        Figure f2 = figureFactory.getRandomFigure();
        Figure f3 = figureFactory.getRandomFigure();
        Figure f4 = figureFactory.getRandomFigure();
        Figure f5 = figureFactory.getRandomFigure();
        Figure f6 = figureFactory.getRandomFigure();
        Figure f7 = figureFactory.getRandomFigure();

        assertEquals(Figure.J, f1.getGridVal());
        assertEquals(Figure.J, f2.getGridVal());
        assertEquals(Figure.L, f3.getGridVal());
        assertEquals(Figure.L, f4.getGridVal());
        assertEquals(Figure.J, f5.getGridVal());
        assertEquals(Figure.J, f6.getGridVal());
        assertEquals(Figure.L, f7.getGridVal());

        assertArrayEquals(new int[]{0,0,0,3,4,0,0}, figureFactory.getCounts());
    }
}
