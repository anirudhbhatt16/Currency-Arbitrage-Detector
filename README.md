# Currency-Arbitrage-Detector
When we exchange money between different currencies, like converting USD to EUR, then EUR to GBP, and finally GBP back to USD, the exchange rates set by banks and trading platforms keep changing. Sometimes, due to these fluctuations, a unique opportunity arises where a trader can follow a specific sequence of currency exchanges and end up with more money than they started—without taking any risks.

This situation is known as Currency Arbitrage, and our goal is to build a system that can automatically detect these profit-making opportunities using graph algorithms.

Currency exchange rates change every second, making it extremely difficult for a person to manually track and identify profitable trades. By the time a trader notices an opportunity, it may already be gone, as many others are also looking for the same chance to make money. That’s why we need a fast and automated solution that can analyze exchange rates in real-time and quickly spot these hidden profit loops before they disappear.

To do this, we use the Bellman-Ford Algorithm, which helps us identify negative weight cycles in a graph representation of currency exchange rates, allowing us to detect arbitrage opportunities instantly and maximize profit.
