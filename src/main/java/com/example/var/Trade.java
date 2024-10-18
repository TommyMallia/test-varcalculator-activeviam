package com.example.var;

public class Trade {
	
    private final String tradeId;
    private final double[] pnlData;

    public Trade(String tradeId, double[] pnlData) {
        this.tradeId = tradeId;
        this.pnlData = pnlData.clone(); // Creates a copy of the array so original remains unchanged
    }

    public String getTradeId() {
        return tradeId;
    }

    public double[] getPnlData() {
        return pnlData.clone();
    }
}
