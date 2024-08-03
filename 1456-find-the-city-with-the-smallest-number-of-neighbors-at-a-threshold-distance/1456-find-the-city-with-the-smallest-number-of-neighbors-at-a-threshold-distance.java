import java.util.*;
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, List<int[]>> adjacency = new HashMap<>();

        for(int i=0; i<edges.length;i++){
            int from = edges[i][0];
            int to = edges[i][1];
            int weight = edges[i][2];

            adjacency.putIfAbsent(from, new ArrayList<>());
            adjacency.putIfAbsent(to, new ArrayList<>());

            adjacency.get(from).add(new int[]{to, weight});
            adjacency.get(to).add(new int[]{from, weight});
        }

        int minreachablecities = Integer.MAX_VALUE;
        int p = -1;

        for(int i=0; i<n; i++){
            int reachablecities = countReachableCities(n, i, adjacency, distanceThreshold);
            if(reachablecities <= minreachablecities){
                minreachablecities = reachablecities;
                p=i;
            }
        }

        return p;
    }

    public int countReachableCities(int n, int startCity, Map<Integer, List<int[]>> adjacency, int threshold){
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);

        distances[startCity] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{startCity, 0});

        while(!pq.isEmpty()){
            int current[] = pq.poll();
            int currentcity = current[0];
            int currentweight = current[1];

            if(currentweight > threshold){
                break;
            }

            if(adjacency.containsKey(currentcity)){
                for(int neighbor[]: adjacency.get(currentcity)){
                    int neighborcity = neighbor[0];
                    int neighborweight = neighbor[1];
                    int newdistance = neighborweight+currentweight;

                    if(newdistance < distances[neighborcity]){
                        distances[neighborcity] = newdistance;
                        pq.add(new int[]{neighborcity, newdistance});
                    }
                }
            }
        }
        int count = 0;
        for(int j=0; j<n; j++){
            if(distances[j] <= threshold){
                count++;
            }
        }
        return count-1;
    }
}