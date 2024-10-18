package com.example.var;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HistoricalVaRCalculatorTest {

    private HistoricalVaRCalculator calculator;
    private double[] historicalPnL;

    @BeforeEach
    public void setUp() {
        calculator = new HistoricalVaRCalculator();
        historicalPnL = new double[]{-20000, 2000, 3000, 15000, -18000, 5000, 1000, -4000, 20000, 30000, -10000, 12000, 5000, -7000, 6000, 4000, -3000, 2500, -1500, 1000};
        
    }

    @AfterEach
    public void tearDown() {
        calculator = null;
        historicalPnL = null;
    }

    @Test
    public void testCalculateVaRSingleTrade95Percent() {
        double confidenceLevel = 0.95;
        double var = calculator.calculateVaR(historicalPnL, confidenceLevel);

        assertEquals(18000, var, 0.01);
    }
    
    @Test
    public void testCalculateVaRSingleTrade99Percent() {
        double confidenceLevel = 0.99;
        double var = calculator.calculateVaR(historicalPnL, confidenceLevel);

        assertEquals(20000, var, 0.01);
    }

}
