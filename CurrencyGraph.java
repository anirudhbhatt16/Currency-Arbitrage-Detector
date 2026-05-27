package backend;

import java.util.*;

public class CurrencyGraph {

    // Stores all currencies (vertices)
    private Set<Currency> currencies;

    // Stores all edges
    private List<Edge> edges;

    // Adjacency list representation
    private Map<Currency, List<Edge>> adjacencyList;

    // Constructor
    public CurrencyGraph() {
        currencies = new HashSet<>();
        edges = new ArrayList<>();
        adjacencyList = new HashMap<>();
    }

    // Add currency (vertex)
    public void addCurrency(Currency currency) {

        currencies.add(currency);

        // Initialize adjacency list if not present
        adjacencyList.putIfAbsent(currency, new ArrayList<>());
    }

    // Add edge (exchange connection)
    public void addEdge(Edge edge) {

        Currency source = edge.getSource();
        Currency destination = edge.getDestination();

        // Ensure both currencies exist
        addCurrency(source);
        addCurrency(destination);

        edges.add(edge);

        // Add to adjacency list
        adjacencyList.get(source).add(edge);
    }

    // Get all currencies
    public Set<Currency> getCurrencies() {
        return currencies;
    }

    // Get all edges
    public List<Edge> getEdges() {
        return edges;
    }

    // Get neighbors of a currency
    public List<Edge> getNeighbors(Currency currency) {
        return adjacencyList.getOrDefault(currency, new ArrayList<>());
    }

    // Graph size
    public int getCurrencyCount() {
        return currencies.size();
    }

    public int getEdgeCount() {
        return edges.size();
    }

    // Print graph (debugging)
    public void printGraph() {

        for (Currency currency : adjacencyList.keySet()) {

            System.out.println(currency.getCode() + " connects to:");

            for (Edge edge : adjacencyList.get(currency)) {

                System.out.println(
                        "   -> " +
                        edge.getDestination().getCode() +
                        " rate: " +
                        edge.getRate()
                );
            }
        }
    }
}