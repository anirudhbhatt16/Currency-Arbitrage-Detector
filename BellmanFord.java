package engine;

import backend.Currency;
import backend.Edge;
import backend.CurrencyGraph;
import backend.TradeCycle;

import java.util.*;

public class BellmanFord {

    public static TradeCycle detectArbitrage(CurrencyGraph graph) {

        Map<Currency, Double> distance = new HashMap<>();
        Map<Currency, Currency> predecessor = new HashMap<>();

        // Pick random start currency
        Currency start = graph.getCurrencies().iterator().next();

        // Initialize distances
        for (Currency currency : graph.getCurrencies()) {

            distance.put(currency, Double.MAX_VALUE);
            predecessor.put(currency, null);
        }

        distance.put(start, 0.0);

        int V = graph.getCurrencyCount();

        // Relax edges V-1 times
        for (int i = 0; i < V - 1; i++) {

            for (Edge edge : graph.getEdges()) {

                Currency u = edge.getSource();
                Currency v = edge.getDestination();

                double weight = edge.getWeight();

                if (distance.get(u) + weight < distance.get(v)) {

                    distance.put(v, distance.get(u) + weight);

                    predecessor.put(v, u);
                }
            }
        }

        // Check for negative cycle
        for (Edge edge : graph.getEdges()) {

            Currency u = edge.getSource();
            Currency v = edge.getDestination();

            double weight = edge.getWeight();

            if (distance.get(u) + weight < distance.get(v)) {

                // Negative cycle found
                return buildCycle(predecessor, v);
            }
        }

        return null;
    }


    // Build cycle path
    private static TradeCycle buildCycle(
            Map<Currency, Currency> predecessor,
            Currency start) {

        Set<Currency> visited = new HashSet<>();

        Currency current = start;

        // Move inside cycle
        while (!visited.contains(current)) {

            visited.add(current);

            current = predecessor.get(current);
        }

        Currency cycleStart = current;

        List<Currency> cycle = new ArrayList<>();

        cycle.add(cycleStart);

        current = predecessor.get(cycleStart);

        while (!current.equals(cycleStart)) {

            cycle.add(current);

            current = predecessor.get(current);
        }

        cycle.add(cycleStart);

        Collections.reverse(cycle);

        TradeCycle tradeCycle = new TradeCycle();

        tradeCycle.setCyclePath(cycle);

        return tradeCycle;
    }

}