package backend;

import java.util.Objects;

public class Currency {

    private String code;
    private String name;
    private String symbol;

    // Full constructor
    public Currency(String code,
                    String name,
                    String symbol) {

        this.code = code;
        this.name = name;
        this.symbol = symbol;
    }

    // Simple constructor (USED BY DATALOADER)
    public Currency(String code) {

        this.code = code;
        this.name = code;
        this.symbol = code;
    }

    // Default constructor
    public Currency() {
    }

    // Getters
    public String getCode() {

        return code;
    }

    public String getName() {

        return name;
    }

    public String getSymbol() {

        return symbol;
    }

    // Setters
    public void setCode(String code) {

        this.code = code;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setSymbol(String symbol) {

        this.symbol = symbol;
    }

    // Equals (graph comparisons)
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null ||
            getClass()!=o.getClass())
            return false;

        Currency currency =
                (Currency) o;

        return Objects.equals(
                code,
                currency.code);
    }

    // HashCode
    @Override
    public int hashCode() {

        return Objects.hash(code);
    }

    // ToString
    @Override
    public String toString() {

        return code;
    }
}