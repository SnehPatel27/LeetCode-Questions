class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        int ans = 0;                          // Final answer: the city index
        int minCount = Integer.MAX_VALUE;     // Track the minimum number of reachable cities
        
        // Adjacency list to represent the graph
        // Each node points to a list of (neighbor, distance)
        List<List<List<Integer>>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Since the graph is undirected, add both (u → v) and (v → u)
        for (int[] i : edges) {
            int source = i[0];
            int destination = i[1];
            int distance = i[2];

            adjList.get(source).add(Arrays.asList(destination, distance));
            adjList.get(destination).add(Arrays.asList(source, distance));
        }

        // Step 2: Run Dijkstra's algorithm from each city
        for (int i = 0; i < n; i++) {
            // Min-heap: [distance, node]
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            pq.offer(new int[]{0, i});  // Start from node `i`

            // Distance array to track shortest distances from node `i` to all other nodes
            int[] distance = new int[n];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[i] = 0;

            // Find shortest distances from node `i` using modified Dijkstra
            findShortestDistances(pq, adjList, distance, i, distanceThreshold);

            // Step 3: Count how many cities are reachable within the threshold
            int count = 0;            
            for (int j = 0; j < n; j++) {
                if (i == j) continue; // skip itself
                if (distance[j] <= distanceThreshold) {
                    count++;
                }
            }

            // Step 4: Update answer if we found a city with fewer or equal reachable cities
            // In case of tie, we prefer the larger index
            if (count <= minCount) {
                minCount = count;
                ans = i;
            }
        }

        return ans; // return the city with minimum reachable cities (max index in case of tie)
    }

    // Modified Dijkstra's algorithm to compute shortest distance from `node`
    // Stops early if current distance exceeds the threshold
    public void findShortestDistances(PriorityQueue<int[]> pq, List<List<List<Integer>>> adjList, int[] distance, int node, int threshold) {

        while (!pq.isEmpty()) {
            int[] a = pq.poll();
            int currentDistance = a[0];
            int currentNode = a[1];

            // Early termination optimization: if we exceed threshold, stop
            if (currentDistance > threshold) {
                break;
            }

            // Visit neighbors
            for (List<Integer> neighbors : adjList.get(currentNode)) {
                int neighborNode = neighbors.get(0);
                int neighborDistance = neighbors.get(1);

                // Relaxation step of Dijkstra: check if shorter path is found
                if (distance[currentNode] + neighborDistance < distance[neighborNode]) {
                    distance[neighborNode] = distance[currentNode] + neighborDistance;
                    pq.offer(new int[]{distance[neighborNode], neighborNode});
                }
            }
        }
    }
}
