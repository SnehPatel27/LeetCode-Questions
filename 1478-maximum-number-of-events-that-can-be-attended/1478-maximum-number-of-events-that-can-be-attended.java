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


            //Keep on adding the events starting on the same day
            //Below in the events[index][0] You can also do == day. because it would never be less then the previous day
            //since the list has been sorted initially
            while(index < n && events[index][0] <= day){
                pq.offer(events[index][1]);
                index++;
            }

            //pull out the event with the lowest end time
            pq.poll();
            result++;
            day++;

            //remove all events that end up before the day++ or all expired event
            while(!pq.isEmpty() && pq.peek() < day){
                pq.poll();
            }
        }

        return result;
    }
}