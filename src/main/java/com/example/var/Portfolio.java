package com.example.var;

import java.util.List;

public class Portfolio {
	
    private final List<Trade> trades;
    private final int numTrades;
    private final int numDays;

    public Portfolio(List<Trade> trades) {
        this.trades = trades;
        this.numTrades = trades.size(); //3
        this.numDays = trades.get(0).getPnlData().length; //7
    }
    
    public int getNumTrades() {
        return numTrades;
    }

    public int getNumDays() {
        return numDays;
    }
    
    public double[][] getPortfolioPnlData() {

        double[][] portfolioPnlData = new double[numTrades][numDays]; // Initialises 2D array with [num rows][num cols]
        for (int i = 0; i < numTrades; i++) {
            portfolioPnlData[i] = trades.get(i).getPnlData();
        }
        
        return portfolioPnlData;
    }
}
