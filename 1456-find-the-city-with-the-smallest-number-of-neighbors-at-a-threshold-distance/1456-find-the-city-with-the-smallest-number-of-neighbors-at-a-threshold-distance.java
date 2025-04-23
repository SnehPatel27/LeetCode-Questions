class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        int ans = 0;
        int minCount = Integer.MAX_VALUE;
        List<List<List<Integer>>> adjList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] i: edges){
            int source = i[0];
            int destination = i[1];
            int distance = i[2];

            adjList.get(source).add(Arrays.asList(destination, distance));
            adjList.get(destination).add(Arrays.asList(source, distance));
        }

        for(int i = 0; i < n; i++){
            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
            pq.offer(new int[]{0, i});
            int[] distance = new int[n];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[i] = 0;
            findShortestDistances(pq, adjList, distance, i);
            int count = 0;            
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                if(distance[j] <= distanceThreshold){
                    count++;
                }
            }
            if(count <= minCount){
                minCount = count;
                ans = i;
            }
        }

        return ans;
    }

    public void findShortestDistances(PriorityQueue<int[]> pq, List<List<List<Integer>>> adjList, int[] distance, int node){

        while(!pq.isEmpty()){
            int[] a = pq.poll();
            int currentDistance = a[0];
            int currentNode = a[1];
        
            for(List<Integer> neighbors: adjList.get(currentNode)){
                int neighborNode = neighbors.get(0);
                int neighborNodeDistance = neighbors.get(1);

                if(distance[currentNode] + neighborNodeDistance < distance[neighborNode]){
                    distance[neighborNode] = distance[currentNode] + neighborNodeDistance;
                    pq.offer(new int[]{distance[neighborNode], neighborNode});
                }
            }
        }
    }
}