class Solution {
    //In case of interview provide me the code that is below.
    public int[][] kClosestt(int[][] points, int k) {
        Map<Double, List<Integer>> distance = new HashMap<>();
        PriorityQueue<Double> pq = new PriorityQueue();
        int[][] result = new int[k][2];

        for(int i = 0; i < points.length; i++){
            double distanceToOrigin = Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
            
            if(pq.size() < k){
                pq.offer(distanceToOrigin);
            } else {
                if(distanceToOrigin < pq.peek()){                    
                    pq.offer(distanceToOrigin);
                }
            }
            

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

    //Provide this code
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1]));
        int[][] result = new int[k][2];

        for(int i = 0; i < points.length; i++){
            pq.offer(points[i]);

            if(pq.size() > k){
                pq.poll();
            }
        }

        int count = 0;
        while(!pq.isEmpty()){
            result[count++] = pq.poll();
        }

        return result;
    }
}