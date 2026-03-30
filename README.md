A graph-based system to detect arbitrage opportunities across multiple currencies using the Bellman-Ford algorithm and negative cycle detection.

Overview
Currency arbitrage occurs when a sequence of currency exchanges results in a profit without any external investment.

This project models currency exchange rates as a weighted directed graph and applies graph algorithms to detect arbitrage opportunities.

How It Works
1 Graph Modeling
Each currency is represented as a vertex.
Each exchange rate (A → B) is represented as a directed edge.
The edge weight corresponds to the exchange rate between currencies.
2 Logarithmic Transformation
Currency exchanges are multiplicative in nature.

If:

A → B = r1
B → C = r2
C → A = r3

Arbitrage exists if:

r1 × r2 × r3 > 1

To use graph algorithms effectively, we convert multiplication into addition using logarithms.

We transform each exchange rate as: weight = -log(exchange_rate)

This converts the condition:

r1 × r2 × r3 > 1

into:

-log(r1) - log(r2) - log(r3) < 0

Thus,

A negative weight cycle in the transformed graph indicates an arbitrage opportunity.

3 Bellman-Ford Algorithm
The Bellman-Ford algorithm is applied to:

Relax edges up to V-1 times
Detect negative weight cycles
If a negative cycle is detected → Arbitrage exists.
If no negative cycle is found → No arbitrage opportunity is present.

🛠 Tech Stack
C++
Graph Algorithms
Bellman-Ford Algorithm
HTML, CSS, JavaScript (Frontend Interface)
JSON (Sample Exchange Data)
Algorithm Complexity
Time Complexity: O(V × E)
Space Complexity: O(V + E)

Where:

V = Number of currencies
E = Number of exchange rates
Testing & Validation
The system is tested using predefined exchange-rate datasets to validate:

Detection of valid arbitrage cycles
Correct handling of non-arbitrage cases
Edge-case scenarios
Future Improvements
Real-time exchange rate API integration
Performance optimization for larger currency graphs
Full backend deployment
Visualization of arbitrage cycle paths
