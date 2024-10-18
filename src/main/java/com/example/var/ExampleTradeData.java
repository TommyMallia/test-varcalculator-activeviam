package com.example.var;

import java.util.Arrays;
import java.util.List;

public class ExampleTradeData implements TradeData {

	@Override
	public List<Trade> getTrades() {
		return Arrays.asList(
	            new Trade("T1", new double[] {-4000, 2000, 3000, -10000, 15000, -20000, 5000}),
	            new Trade("T2", new double[] {2000, -3000, 4000, 5000, -10000, 2000, -4000}),
	            new Trade("T3", new double[] {3000, 1000, -12000, 4000, 3000, -5000, 2000})
	            );
	}
}
