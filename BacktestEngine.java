package backtest;

import backend.CurrencyGraph;
import backend.ExchangeRate;
import backend.GraphBuilder;
import backend.TradeCycle;
import backtest.engine.ArbitrageDetector;
import backtest.engine.ProfitCalculator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BacktestEngine {

    public static List<BacktestResult> runBacktest(

            Map<LocalDate,List<ExchangeRate>> historicalData){

        List<BacktestResult> results =
                new ArrayList<>();

        for(LocalDate date : historicalData.keySet()){

            List<ExchangeRate> rates =
                    historicalData.get(date);

            CurrencyGraph graph =
                    GraphBuilder.buildGraph(rates);

            TradeCycle cycle =
                    ArbitrageDetector.findArbitrage(graph);

            boolean found = (cycle != null);

            // Calculate profit if cycle exists
            if(found){

                double profit =
                        ProfitCalculator.calculateProfit(cycle,graph);

                cycle.setProfitPercentage(profit);
            }

            BacktestResult result =
                    new BacktestResult(
                            date,
                            cycle,
                            found);

            results.add(result);
        }

        return results;
    }

    public static void printResults(
            List<BacktestResult> results){

        for(BacktestResult result : results){

            result.printResult();

            System.out.println("----------------");
        }
    }

}