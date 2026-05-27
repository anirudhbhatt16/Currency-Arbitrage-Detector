package backend;

public class Edge {

    private Currency source;
    private Currency destination;
    private double weight;
    private double rate;

    // Constructor
    public Edge(Currency source, Currency destination, double rate) {
        this.source = source;
        this.destination = destination;
        this.rate = rate;
        this.weight = -Math.log(rate);
    }

    // Getters
    public Currency getSource() {
        return source;
    }

    public Currency getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }

    public double getRate() {
        return rate;
    }

    // Setters
    public void setSource(Currency source) {
        this.source = source;
    }

    public void setDestination(Currency destination) {
        this.destination = destination;
    }

    public void setRate(double rate) {
        this.rate = rate;
        this.weight = -Math.log(rate);
    }

    // ToString for debugging
    @Override
    public String toString() {
        return source.getCode() + " -> " +
               destination.getCode() +
               " | Rate: " + rate +
               " | Weight: " + weight;
    }
}