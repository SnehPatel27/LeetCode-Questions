class Pair{
    int first;
    int second;

    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Tuple{
    int first;
    int second;
    int third;

    Tuple(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < flights.length; i++){
            adjList.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(0, src, 0));

        int[] distanceA = new int[n];
        for(int i = 0; i < n; i++){
            distanceA[i] = Integer.MAX_VALUE;
        }

        while(!q.isEmpty()){
            Tuple tup = q.poll();
            int stops = tup.first;
            int node = tup.second;
            int distance = tup.third;

            if(stops > k) continue;

            for(Pair neighbors: adjList.get(node)){
                int neighborNode = neighbors.first;
                int neighborDistance = neighbors.second;

                if(distance + neighborDistance < distanceA[neighborNode] && stops <= k){
                    distanceA[neighborNode] = distance + neighborDistance;
                    q.offer(new Tuple(stops + 1, neighborNode, distanceA[neighborNode]));
                }
            }
        }

        if(distanceA[dst] == Integer.MAX_VALUE) return -1;
        return distanceA[dst];
    }
}