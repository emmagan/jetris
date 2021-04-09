package com.devng.jetris;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FigureFactoryTest {
    private FigureFactory figureFactory;

    @BeforeEach
    public void setup() {
        Random r = mock(Random.class);
        figureFactory = new FigureFactory(r);
    }

    @Test
    public void testGetRandomFigure() {
        assertEquals(new FigureI(),figureFactory.getRandomFigure());
    }

}
