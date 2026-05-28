package backtest;

import backend.Currency;
import backend.CurrencyGraph;
import backend.Edge;

import java.util.List;

public class PortfolioSimulator {

    public static double simulate(

            double initialAmount,
            List<Currency> cycle,
            CurrencyGraph graph,
            double transactionFeePercent
    ){

        double amount = initialAmount;

        for(int i=0;i<cycle.size()-1;i++){

            Currency from = cycle.get(i);

            Currency to = cycle.get(i+1);

            double rate = findRate(from,to,graph);

            amount = amount * rate;

            // Apply transaction fee
            amount = amount * (1 - transactionFeePercent/100);

        }

        return amount;
    }


    private static double findRate(

            Currency from,
            Currency to,
            CurrencyGraph graph){

        for(Edge edge : graph.getNeighbors(from)){

            if(edge.getDestination().equals(to)){

                return edge.getRate();
            }
        }

        return 1.0;
    }

}