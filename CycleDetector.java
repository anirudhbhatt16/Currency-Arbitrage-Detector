package engine;

import backend.Currency;
import backend.TradeCycle;

import java.util.*;

public class CycleDetector {

    public static TradeCycle buildCycle(
            Map<Currency, Currency> predecessor,
            Currency start) {

        Set<Currency> visited = new HashSet<>();

        Currency current = start;

        // Move until we enter cycle
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