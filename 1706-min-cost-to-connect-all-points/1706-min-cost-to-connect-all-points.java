class Solution1 {
    public int minCostConnectPoints(int[][] points) {
        
        int nodes = points.length;

        // Initialize adjacency list to store graph edges
        // Each node has a list of [neighbor, weight] pairs
        List<List<List<Integer>>> adjList = new ArrayList<>();

        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }

        // Build the full undirected graph with Manhattan distances
        // Time: O(N^2) where N = number of points
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                if (i == j) continue;

                // Compute Manhattan distance between points[i] and points[j]
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);

                // Add edge from i → j with weight = distance
                // Note: No need to add j → i again since we will still reach every node via Prim's expansion
                adjList.get(i).add(Arrays.asList(j, distance));
            }
        }

        // Priority queue stores [edgeWeight, targetNode], always processes the minimum edge first
        // Time per offer/poll = O(log N)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Start Prim’s algorithm from node 0 with cost 0
        pq.offer(new int[]{0, 0});

        // Track visited nodes to avoid cycles and duplicates
        int[] visited = new int[nodes];

        // Stores the total minimum cost of the MST
        int minCost = 0;

        // Prim’s core loop: process the smallest available edge that leads to an unvisited node
        while (!pq.isEmpty()) {
            int[] a = pq.poll();
            int weight = a[0];
            int node = a[1];

            // If node already visited, skip it
            if (visited[node] != 0) continue;

            // Mark node as visited
            visited[node] = 1;

            // Add current edge's cost to total
            minCost += weight;

            // Explore all unvisited neighbors and add to priority queue
            for (List<Integer> neighborNode : adjList.get(node)) {
                int neighbor = neighborNode.get(0);
                int edgeWeight = neighborNode.get(1);

                if (visited[neighbor] == 0) {
                    pq.offer(new int[]{edgeWeight, neighbor});
                }
            }
        }

        // Return total cost to connect all points using MST
        return minCost;
    }
}


// Time Complexity:
// O(N^2) to build the complete graph
// O(N log N) for Prim’s traversal (each node processed once, each edge at most once)

// Space Complexity:
// O(N^2) for the adjacency list
// O(N) for visited[]
// O(N) for the priority queue (in worst case)

//Another Solution Using Krushkals
class DisjointSet{

    int[] size;
    int[] parent;

    DisjointSet(int n){
        size = new int[n];
        parent = new int[n];
        for(int i = 0; i < n; i++){
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int findParent(int node){

        if(node == parent[node]){
            return node;
        }

        int ultimateParent = findParent(parent[node]);
        parent[node] = ultimateParent;
        return ultimateParent; // Or could return parent.get(node);
    }

    public void unionBySize(int node1, int node2){
        int parentOfNode1 = findParent(node1);
        int parentOfNode2 = findParent(node2);

        if(parentOfNode1 == parentOfNode2){
            return;
        }

        if(size[parentOfNode2] > size[parentOfNode1]){
            parent[parentOfNode1] = parentOfNode2;
            size[parentOfNode2] += size[parentOfNode1];
        } else {
            parent[parentOfNode2] = parentOfNode1;
            size[parentOfNode1] += size[parentOfNode2];
        }
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int nodes = points.length;

        // Step 1: Store all possible edges with their Manhattan distances
        // Each edge is represented as: [distance, point1, point2]
        List<int[]> edges = new ArrayList<>();

        DisjointSet ds = new DisjointSet(nodes);  // Union-Find data structure

        // Build the full undirected graph (complete graph)
        // Time: O(N^2) where N is the number of points
        for (int i = 0; i < nodes; i++) {
            for (int j = i + 1; j < nodes; j++) {
                int distance = Math.abs(points[j][0] - points[i][0]) + 
                               Math.abs(points[j][1] - points[i][1]);
                edges.add(new int[]{distance, i, j});
            }
        }

        int minCost = 0;

        // Step 2: Sort all edges by their weights (distance)
        // Time: O(E log E), where E is number of edges ≈ N^2
        Collections.sort(edges, (a, b) -> a[0] - b[0]);

        // Step 3: Iterate over sorted edges and apply Kruskal's algorithm
        for (int i = 0; i < edges.size(); i++) {
            int distance = edges.get(i)[0];
            int node1 = edges.get(i)[1];
            int node2 = edges.get(i)[2];

            // Only connect components that are not already connected
            if (ds.findParent(node1) != ds.findParent(node2)) {
                minCost += distance;  // Add edge to MST
                ds.unionBySize(node1, node2);  // Union the components
            }
        }

        return minCost;  // Return total weight of MST
    }
}

/* 
Time Complexity:
Building edge list: O(N²)

Sorting edges: O(E log E) where E = N * (N - 1) / 2 ≈ N²

Union-Find operations: O(E * α(N)) ≈ O(E) due to near-constant inverse Ackermann time

✅ Overall Time Complexity: O(N² log N)

Space Complexity:
Edge list: O(N²)

Disjoint set data structures (parent[], size[]): O(N)

✅ Overall Space Complexity: O(N²)
*/