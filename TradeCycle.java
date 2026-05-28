package backend;

import java.util.ArrayList;
import java.util.List;

public class TradeCycle {

    private List<Currency> cyclePath;
    private double profitPercentage;

    // Constructor
    public TradeCycle(List<Currency> cyclePath,
                      double profitPercentage) {

        this.cyclePath = cyclePath;
        this.profitPercentage = profitPercentage;
    }

    // Default constructor
    public TradeCycle() {

        this.cyclePath = new ArrayList<>();
        this.profitPercentage = 0.0;
    }

    // Getters
    public List<Currency> getCyclePath() {

        return cyclePath;
    }

    public double getProfitPercentage() {

        return profitPercentage;
    }

    // Setters
    public void setCyclePath(
            List<Currency> cyclePath) {

        this.cyclePath = cyclePath;
    }

    public void setProfitPercentage(
            double profitPercentage) {

        this.profitPercentage = profitPercentage;
    }

    // Helper methods (VERY USEFUL)
    public int size(){

        return cyclePath.size();
    }

    public Currency get(int index){

        return cyclePath.get(index);
    }

    // Print cycle nicely
    public void printCycle() {

        if (cyclePath == null ||
                cyclePath.isEmpty()) {

            System.out.println("No cycle found");

            return;
        }

        for (int i = 0;
             i < cyclePath.size();
             i++) {

            System.out.print(
                    cyclePath.get(i).getCode());

            if (i != cyclePath.size()-1) {

                System.out.print(" -> ");
            }
        }

        System.out.println();

        System.out.printf("Profit: %.4f %%\n", profitPercentage);
    }

    // Convert cycle to string
    @Override
    public String toString() {

        if(cyclePath == null ||
           cyclePath.isEmpty()){

            return "No cycle";
        }

        StringBuilder builder =
                new StringBuilder();

        for (int i = 0;
             i < cyclePath.size();
             i++) {

            builder.append(
                    cyclePath.get(i).getCode());

            if (i != cyclePath.size()-1) {

                builder.append(" -> ");
            }
        }

        builder.append(" | Profit: ");

        builder.append(profitPercentage);

        builder.append("%");

        return builder.toString();
    }
}