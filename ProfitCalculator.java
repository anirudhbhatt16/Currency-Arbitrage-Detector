package backtest.engine;

import backend.Currency;
import backend.Edge;
import backend.TradeCycle;
import backend.CurrencyGraph;

import java.util.List;

public class ProfitCalculator {

    public static double calculateProfit(
            TradeCycle cycle,
            CurrencyGraph graph) {

        double amount = 1.0;

        List<Currency> path =
                cycle.getCyclePath();

        // Traverse cycle
        for (int i = 0; i < path.size() - 1; i++) {

            Currency from = path.get(i);
            Currency to = path.get(i + 1);

            double rate =
                    findRate(from,to,graph);

            amount = amount * rate;
        }

        double profit =
                (amount - 1.0) * 100;

        return profit;
    }


    private static double findRate(

            Currency from,
            Currency to,
            CurrencyGraph graph) {

        for (Edge edge :
                graph.getNeighbors(from)) {

            if (edge.getDestination()
                    .equals(to)) {

                return edge.getRate();
            }
        }

        return 1.0;
    }

}