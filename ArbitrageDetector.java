package backtest.engine;

import backend.CurrencyGraph;
import backend.TradeCycle;

public class ArbitrageDetector {

    public static TradeCycle findArbitrage(CurrencyGraph graph) {

        TradeCycle cycle =
                BellmanFord.detectArbitrage(graph);

        if (cycle == null) {

            System.out.println("No arbitrage opportunity found");

            return null;
        }

        System.out.println("Arbitrage opportunity detected!");

        return cycle;
    }

    // Helper method to print result cleanly
    public static void printResult(TradeCycle cycle) {

        if (cycle == null) {

            System.out.println("No profitable cycle");

            return;
        }

        System.out.println("Trade Path:");

        cycle.printCycle();
    }

}