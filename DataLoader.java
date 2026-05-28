package backtest;

import backend.Currency;
import backend.ExchangeRate;

import java.io.BufferedReader;
import java.io.FileReader;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataLoader {

    public static Map<LocalDate,List<ExchangeRate>>
    loadHistoricalData(String filePath){

        Map<LocalDate,List<ExchangeRate>> data =
                new LinkedHashMap<>();

        try{

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(filePath));

            String line;

            // Skip header
            reader.readLine();

            while((line = reader.readLine())!=null){

                // Skip empty lines
                if(line.trim().isEmpty()){
                    continue;
                }

                String[] parts =
                        line.split(",");

                if(parts.length < 4){
                    continue;
                }

                String dateStr =
                        parts[0].trim();

                // Safety check
                if(dateStr.equalsIgnoreCase("date")){
                    continue;
                }

                LocalDate date =
                        LocalDate.parse(dateStr);

                String from =
                        parts[1].trim();

                String to =
                        parts[2].trim();

                double rate =
                        Double.parseDouble(
                                parts[3].trim());

                // Create currencies
                Currency fromCurrency =
                        new Currency(from);

                Currency toCurrency =
                        new Currency(to);

                ExchangeRate exchangeRate =
                        new ExchangeRate(
                                fromCurrency,
                                toCurrency,
                                rate,
                                date);

                // Add to map
                if(!data.containsKey(date)){

                    data.put(date,
                            new ArrayList<>());
                }

                data.get(date)
                        .add(exchangeRate);
            }

            reader.close();

        }
        catch(Exception e){

            System.out.println(
                    "Error loading CSV");

            e.printStackTrace();
        }

        return data;
    }

}