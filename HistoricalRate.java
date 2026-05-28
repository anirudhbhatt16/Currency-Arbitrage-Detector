package backtest;

import backend.ExchangeRate;

import java.time.LocalDate;
import java.util.List;

public class HistoricalRate {

    private LocalDate date;

    private List<ExchangeRate> rates;

    // Constructor
    public HistoricalRate(
            LocalDate date,
            List<ExchangeRate> rates){

        this.date = date;

        this.rates = rates;
    }

    // Default constructor
    public HistoricalRate(){

    }

    public LocalDate getDate(){

        return date;
    }

    public List<ExchangeRate> getRates(){

        return rates;
    }

    public void setDate(LocalDate date){

        this.date = date;
    }

    public void setRates(
            List<ExchangeRate> rates){

        this.rates = rates;
    }

    // Helper method
    public int size(){

        if(rates == null)
            return 0;

        return rates.size();
    }

    // Print data
    public void printRates(){

        System.out.println(
                "Date: " + date);

        if(rates == null ||
           rates.isEmpty()){

            System.out.println(
                    "No data");

            return;
        }

        for(ExchangeRate rate : rates){

            System.out.println(rate);
        }
    }

}