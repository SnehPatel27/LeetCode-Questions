class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Map<Double, List<Integer>> distance = new HashMap<>();
        PriorityQueue<Double> pq = new PriorityQueue();
        int[][] result = new int[k][2];

        for(int i = 0; i < points.length; i++){
            double distanceToOrigin = Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
            pq.offer(distanceToOrigin);

            distance.putIfAbsent(distanceToOrigin, new ArrayList<>());
            distance.get(distanceToOrigin).add(i);
        }

        int count = 0;

        while(count < k){

            List<Integer> temp = distance.get(pq.poll());

            for(int id: temp){
                if(count == k) return result;
                result[count++] = points[id];
            }
        }

        return result;
    }
}