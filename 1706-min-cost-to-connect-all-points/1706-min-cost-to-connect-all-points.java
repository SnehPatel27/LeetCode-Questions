//This is the questions about finding the minimum cost spanning tree. First I need to have the adjList for all the edges possible and then I would use that graph to find the MST. In this case I would be using prims algorithm. 
class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        int nodes = points.length;
        List<List<List<Integer>>> adjList = new ArrayList<>();

        for(int i = 0; i < nodes; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < nodes; i++){
            for(int j = 0; j < nodes; j++){
                if(i == j) continue;
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                adjList.get(i).add(Arrays.asList(j, distance));
            }   
        }


        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0});

        int[] visited = new int[nodes];

        int minCost = 0;

        while(!pq.isEmpty()){
            int[] a = pq.poll();
            int weight = a[0];
            int node = a[1];

            if(visited[node] != 0) continue;
            visited[node] = 1;

            minCost += weight;

            for(List<Integer> neighborNode: adjList.get(node)){
                if(visited[neighborNode.get(0)] == 0){
                    pq.offer(new int[]{neighborNode.get(1), neighborNode.get(0)});
                } 
            }

        }

        return minCost;
    }
}