// Pair class: used to represent a graph edge (destination, cost)
class Pair {
    int first;   // destination node
    int second;  // cost to reach that node

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

// Tuple class: used in BFS queue
// Represents (stops made so far, current node, total cost to reach this node)
class Tuple {
    int first;   // number of stops used to reach this node
    int second;  // current node
    int third;   // total accumulated cost to reach this node

    Tuple(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {

    // Main method to find the cheapest flight with at most k stops
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // Step 1: Build adjacency list from input flights
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Each flight is [from, to, cost]
        for (int[] flight : flights) {
            int from = flight[0], to = flight[1], cost = flight[2];
            adjList.get(from).add(new Pair(to, cost));
        }

        // Step 2: BFS queue to traverse with tracking (stops, node, cost)
        // We prioritize lower stops rather than cost — since the constraint is on stops
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(0, src, 0)); // Start from source, 0 stops, 0 cost

        // Step 3: Distance array to store minimum cost to reach each node
        // Initialized to infinity
        int[] distanceA = new int[n];
        for (int i = 0; i < n; i++) {
            distanceA[i] = Integer.MAX_VALUE;
        }

        // Step 4: BFS traversal
        while (!q.isEmpty()) {
            Tuple tup = q.poll();
            int stops = tup.first;
            int node = tup.second;
            int distance = tup.third;

            // If stops exceed allowed limit, ignore this path
            if (stops > k) continue;

            // Check all adjacent neighbors
            for (Pair neighbor : adjList.get(node)) {
                int neighborNode = neighbor.first;
                int neighborCost = neighbor.second;

                // If the new path to neighbor is cheaper, and within stop limit
                if (distance + neighborCost < distanceA[neighborNode]) {
                    distanceA[neighborNode] = distance + neighborCost;

                    // Add neighbor to the queue with increased stop count
                    q.offer(new Tuple(stops + 1, neighborNode, distanceA[neighborNode]));
                }
            }
        }

        // Step 5: Return the cheapest cost to reach destination
        if (distanceA[dst] == Integer.MAX_VALUE) return -1;
        return distanceA[dst];
    }
}
