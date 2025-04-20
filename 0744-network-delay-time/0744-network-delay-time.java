class Solution {
    //This is using Dijkstra Algorithm
    public int networkDelayTime(int[][] times, int n, int k) {
        
        int[] distance = new int[n + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        List<List<List<Integer>>> adjList = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int edge[]: times){
            int source = edge[0];
            int target = edge[1];
            int weight = edge[2];

            adjList.get(source).add(Arrays.asList(weight, target));
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        pq.offer(new int[]{0, k});

        while(!pq.isEmpty()){

            int[] a = pq.poll();
            
            int dist = a[0];
            int node = a[1];

            for(List<Integer> neighbor: adjList.get(node)){
                int neighborNodeDistance = neighbor.get(0);
                int neighborNode = neighbor.get(1);

                if(dist + neighborNodeDistance < distance[neighborNode]){
                    distance[neighborNode] = dist + neighborNodeDistance;
                    pq.offer(new int[]{distance[neighborNode], neighborNode});
                }
            }
        }

        int maxTime = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            if(distance[i] == Integer.MAX_VALUE){
                return -1;
            }
            maxTime = Math.max(distance[i], maxTime);
        }

        return maxTime;
    }
}