package com.example.var;

public class VaRCalculatorService {
    private final VaRCalculator calculator;
    private final double confidenceLevel;

    public VaRCalculatorService(VaRCalculator calculator, double confidenceLevel) {
        this.calculator = calculator;
        this.confidenceLevel = confidenceLevel;
    }

    public double calculateTradeVaR(Trade trade) {
        return calculator.calculateVaR(trade.getPnlData(), confidenceLevel);
    }

    public double calculatePortfolioVaR(Portfolio portfolio) {
        return calculator.calculatePortfolioVaR(portfolio, confidenceLevel);
    }
}