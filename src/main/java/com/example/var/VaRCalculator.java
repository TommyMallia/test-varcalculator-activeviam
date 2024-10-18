package com.example.var;

public interface VaRCalculator {
	
    double calculateVaR(double[] pnlData, double confidenceLevel);
    double calculatePortfolioVaR(Portfolio portfolio, double confidenceLevel);
}
