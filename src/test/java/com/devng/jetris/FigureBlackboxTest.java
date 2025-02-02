package com.devng.jetris;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class FigureBlackboxTest {
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
    public void testInstanceOf() {
        Assertions.assertTrue(figureI instanceof Figure);
        Assertions.assertTrue(figureJ instanceof Figure);
        Assertions.assertTrue(figureL instanceof Figure);
        Assertions.assertTrue(figureO instanceof Figure);
        Assertions.assertTrue(figureS instanceof Figure);
        Assertions.assertTrue(figureT instanceof Figure);
        Assertions.assertTrue(figureZ instanceof Figure);
    }
}
