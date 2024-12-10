class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> Integer.compare(a[0], b[0]));

        int day = 0;
        int index = 0;
        int result = 0;
        int n = events.length;


        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while(!pq.isEmpty() || index < n){
            if(pq.isEmpty()){
                day = events[index][0];
            }

            while(index < n && events[index][0] <= day){
                pq.offer(events[index][1]);
                index++;
            }

            pq.poll();
            result++;
            day++;

            while(!pq.isEmpty() && pq.peek() < day){
                pq.poll();
            }
        }

        return result;
    }
}