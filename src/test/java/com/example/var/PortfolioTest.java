package com.example.var;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;

public class PortfolioTest {
    
    private Portfolio portfolio;
    private VaRCalculator varCalculator;
    private Trade trade1, trade2, trade3, trade4;

    @BeforeEach
    public void setUp() {

        varCalculator = new HistoricalVaRCalculator();
        
        // Initialise the portfolio with trades before each test
        trade1 = new Trade("T1", new double[] {-20000, 2000, 3000, 15000, -18000, 5000, 1000, -4000, 20000, 30000, -10000, 12000, 5000, -7000, 6000, 4000, -3000, 2500, -1500, 1000});
        trade2 = new Trade("T2", new double[] {2000, -3000, 4000, -10000, 2000, -4000, 3000, 5000, -1000, 1500, 1000, 500, -500, 2000, -2500, 3000, -1000, 2000, -2000, 1500});
        trade3 = new Trade("T3", new double[] {1000, 2000, -5000, 7000, -3000, 4000, 6000, -4000, 2000, -500, 1000, -2000, 2500, -500, 500, 3000, -1000, 4000, -1500, 2000});
        trade4 = new Trade("T4", new double[] {-10000, 4000, 3000, -2000, 7000, 6000, -8000, 2000, -5000, 3000, 2000, 1000, 0, -4000, 3500, 2500, -3000, 1000, 4000, -2000});
        
    }

    @AfterEach
    public void tearDown() {
        portfolio = null;
        varCalculator = null;
    }

    @Test
    public void testCalculatePortfolioVaRForTwoTradesAt95Percent() {
    	
        portfolio = new Portfolio(Arrays.asList(trade1, trade2));
        
        double confidenceLevel = 0.95;        
        double portfolioVaR = varCalculator.calculatePortfolioVaR(portfolio, confidenceLevel); // Calculate VaR for a portfolio

        assertEquals(16000, portfolioVaR, 0.01);
    }
    
    @Test
    public void testCalculatePortfolioVaRForFourTradesAt95Percent() {
    	
        portfolio = new Portfolio(Arrays.asList(trade1, trade2, trade3, trade4));
        
        double confidenceLevel = 0.95;        
        double portfolioVaR = varCalculator.calculatePortfolioVaR(portfolio, confidenceLevel); 

        assertEquals(12000, portfolioVaR, 0.01);
    }
    
    @Test
    public void testCalculatePortfolioVaRForTwoTradesAt99Percent() {
    	
        portfolio = new Portfolio(Arrays.asList(trade1, trade2));
        
        double confidenceLevel = 0.99;        
        double portfolioVaR = varCalculator.calculatePortfolioVaR(portfolio, confidenceLevel);

        assertEquals(18000, portfolioVaR, 0.01);
    }
    
    @Test
    public void testCalculatePortfolioVaRForFourTradesAt99Percent() {
    	
        portfolio = new Portfolio(Arrays.asList(trade1, trade2, trade3, trade4));
        
        double confidenceLevel = 0.99; //
        double portfolioVaR = varCalculator.calculatePortfolioVaR(portfolio, confidenceLevel);

        assertEquals(27000, portfolioVaR, 0.01);
    }
}
