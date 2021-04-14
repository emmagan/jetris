package com.devng.jetris;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TetrisGridTest {
    private TetrisGrid tg;

    @BeforeEach
    public void setup() {
        tg = new TetrisGrid();
    }

    @Test
    public void testGetLevelInitial() {
        assertEquals(0, tg.getLevel());
    }

    @Test
    public void testGetLinesInitial() {
        assertEquals(0, tg.getLines());
    }

    @Test
    public void testGetScoreInitial() {
        assertEquals(0, tg.getScore());
    }
}
