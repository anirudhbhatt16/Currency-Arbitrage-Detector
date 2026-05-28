package backend;

import java.util.List;

public class GraphBuilder {

    // Build graph from exchange rates
    public static CurrencyGraph buildGraph(List<ExchangeRate> rates) {

        CurrencyGraph graph = new CurrencyGraph();

        for (ExchangeRate rate : rates) {

            Currency from = rate.getFromCurrency();
            Currency to = rate.getToCurrency();

            double exchangeRate = rate.getRate();

            // Create edge
            Edge edge = new Edge(from, to, exchangeRate);

            // Add to graph
            graph.addEdge(edge);
        }

        return graph;
    }

}