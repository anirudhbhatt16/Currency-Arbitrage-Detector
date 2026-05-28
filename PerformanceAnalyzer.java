package backtest;

import backend.TradeCycle;

import java.util.List;

public class PerformanceAnalyzer {

    public static void analyze(List<BacktestResult> results){

        int totalDays = results.size();

        int arbitrageDays = 0;

        double totalProfit = 0;

        double maxProfit = Double.MIN_VALUE;

        double minProfit = Double.MAX_VALUE;

        for(BacktestResult result : results){

            if(result.isArbitrageFound()){

                arbitrageDays++;

                TradeCycle cycle = result.getCycle();

                double profit =
                        cycle.getProfitPercentage();

                totalProfit += profit;

                if(profit > maxProfit)
                    maxProfit = profit;

                if(profit < minProfit)
                    minProfit = profit;

            }
        }

        double avgProfit = 0;

        if(arbitrageDays > 0){

            avgProfit = totalProfit/arbitrageDays;
        }

        double successRate =
                (double)arbitrageDays/totalDays * 100;

        System.out.println("Backtest Performance");

        System.out.println("Total Days: "+totalDays);

        System.out.println("Arbitrage Days: "+arbitrageDays);

       System.out.printf("Success Rate: %.2f %%\n", successRate);

        System.out.println("Average Profit: " + avgProfit + "%");

       System.out.printf("Max Profit: %.4f %%\n", maxProfit);

System.out.printf("Min Profit: %.4f %%\n", minProfit);
    }

}