package backtest;

import backend.TradeCycle;

import java.time.LocalDate;

public class BacktestResult {

    private LocalDate date;

    private TradeCycle cycle;

    private boolean arbitrageFound;

    public BacktestResult(
            LocalDate date,
            TradeCycle cycle,
            boolean arbitrageFound) {

        this.date = date;
        this.cycle = cycle;
        this.arbitrageFound = arbitrageFound;
    }

    public LocalDate getDate() {
        return date;
    }

    public TradeCycle getCycle() {
        return cycle;
    }

    public boolean isArbitrageFound() {
        return arbitrageFound;
    }

    public void printResult() {

        System.out.println("Date: " + date);

        if(!arbitrageFound){

            System.out.println("No arbitrage opportunity");

            return;
        }

        System.out.println("Arbitrage Found:");

        cycle.printCycle();
    }

}