package com.example.var;

import java.util.Arrays;

public class HistoricalVaRCalculator implements VaRCalculator {

    @Override
    public double calculateVaR(double[] pnlData, double confidenceLevel) {
    	
    	Arrays.sort(pnlData);  // Simple sort for P&L data in ascending order (small data-set)

    	// After sorting, we want the index in the array that corresponds with our confidence level
        int index = (int) Math.floor((1 - confidenceLevel) * pnlData.length);
        index = Math.max(0, Math.min(index, pnlData.length - 1));

        double varValue = Math.abs(pnlData[index]); // Positive value at that index
        
        return varValue;
    }

    @Override
    public double calculatePortfolioVaR(Portfolio portfolio, double confidenceLevel) {

        double[][] portfolioPnlData = portfolio.getPortfolioPnlData();
        int numTrades = portfolio.getNumTrades();
        int numDays = portfolio.getNumDays();

        double[] portfolioTotalPnl = new double[numDays]; // Array to hold total P&L for each day
        
        // Loop through each day to calculate total P&L
        for (int day = 0; day < numDays; day++) {
            double dailyPnl = 0;
            
            for (int trade = 0; trade < numTrades; trade++) {
            	dailyPnl += portfolioPnlData[trade][day]; // Sum up the P&L for each trade on that day
            }
            portfolioTotalPnl[day] = dailyPnl; // Store the total P&L for the day
        }

        double portfolioVaR = calculateVaR(portfolioTotalPnl, confidenceLevel); // Calculate VaR using the total P&L
        
        return portfolioVaR;
    }
}
