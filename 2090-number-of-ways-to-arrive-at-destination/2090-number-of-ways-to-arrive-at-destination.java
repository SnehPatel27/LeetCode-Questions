class Solution {
    public int countPaths(int n, int[][] roads) {

        int MOD = 1000000007;
        
        List<List<List<Integer>>> adjList = new ArrayList<>();

        long[] distance = new long[n];
        int[] ways = new int[n];

        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
            distance[i] = Long.MAX_VALUE;
            ways[i] = 0;
        }

        distance[0] = 0;
        ways[0] = 1;

        for(int[] i: roads){
            int source = i[0];
            int destination = i[1];
            int weight = i[2];

            adjList.get(source).add(Arrays.asList(destination, weight));
            adjList.get(destination).add(Arrays.asList(source, weight));
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0, 0});

        while(!pq.isEmpty()){
            long a[] = pq.poll();
            long edgeWeight = a[0];
            int node = (int)a[1];

            for(List<Integer> neighbors: adjList.get(node)){
                int neighborNode = neighbors.get(0);
                int neighborEdgeWeight = neighbors.get(1); 

                if(edgeWeight + neighborEdgeWeight < distance[neighborNode]){
                    distance[neighborNode] = edgeWeight + neighborEdgeWeight;
                    ways[neighborNode] = ways[node];
                    pq.offer(new long[]{distance[neighborNode], neighborNode});
                }

                else if(edgeWeight + neighborEdgeWeight == distance[neighborNode]){
                    ways[neighborNode] = (ways[neighborNode] + ways[node]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}