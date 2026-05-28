package frontend;

import backtest.BacktestEngine;
import backtest.BacktestResult;
import backtest.DataLoader;
import backtest.PerformanceAnalyzer;

import backend.ExchangeRate;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        System.out.println("Currency Arbitrage System");
        System.out.println("-------------------------");

        // CSV file path
       String filePath = "data/rates_sample.csv";

        // Load data
        Map<LocalDate,List<ExchangeRate>>
                historicalData =

                DataLoader
                .loadHistoricalData(filePath);

        System.out.println(
                "Data Loaded: "
                + historicalData.size()
                + " days");

        // Run backtest
        List<BacktestResult> results =

                BacktestEngine
                .runBacktest(historicalData);

        System.out.println(
                "Backtest completed");

        // Print results
        BacktestEngine
                .printResults(results);

        // Analyze performance
        PerformanceAnalyzer
                .analyze(results);

        System.out.println(
                "System Finished");

    }

}