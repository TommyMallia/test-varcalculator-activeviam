package com.example.var;

import java.util.Scanner;

public class MainVaR {

	public static void main(String[] args) {
		
		// Get the data
		TradeData trades = new ExampleTradeData();
		Portfolio portfolio = new Portfolio(trades.getTrades());
		
		// Get user input
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your confidence level (e.g. 95/97/99): ");
		double confidence = sc.nextDouble()/100;
		System.out.print("Choose a trade you would like to calculate (1, 2 or 3): ");
		int tradeKey = sc.nextInt()-1;
		sc.close();

        // Setup the calculator
		VaRCalculator calculator = new HistoricalVaRCalculator();
		VaRCalculatorService varService = new VaRCalculatorService(calculator, confidence);

        // Calculate VaRs
        double tradeVaR = varService.calculateTradeVaR(trades.getTrades().get(tradeKey));
        double portfolioVaR = varService.calculatePortfolioVaR(portfolio);

        // Print results
        System.out.printf("VaR for Trade 1 at 95%% confidence level: %.2f\n", tradeVaR);
        System.out.printf("VaR for the Portfolio at 95%% confidence level: %.2f\n", portfolioVaR);
	}

}
