package backtest;

import backend.CurrencyGraph;
import backend.TradeCycle;

import java.util.List;

public class StrategySimulator {

    public static double simulateStrategy(

            double initialCapital,
            List<BacktestResult> results,
            CurrencyGraph graph,
            double minProfitPercent,
            double transactionFee){

        double capital = initialCapital;

        for(BacktestResult result : results){

            if(!result.isArbitrageFound())
                continue;

            TradeCycle cycle =
                    result.getCycle();

            double profit =
                    cycle.getProfitPercentage();

            // Strategy rule
            if(profit < minProfitPercent)
                continue;

            double gain =
                    capital * (profit/100);

            double fee =
                    gain * (transactionFee/100);

            capital =
                    capital + gain - fee;
        }

        return capital;
    }

}