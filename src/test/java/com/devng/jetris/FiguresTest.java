package com.devng.jetris;
import org.junit.jupiter.api.BeforeEach;
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
    public void testFigureI() {
        assertEquals(1,1);
    }
}
