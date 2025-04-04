class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> headers = new PriorityQueue<>();
        PriorityQueue<Integer> footers = new PriorityQueue<>();

        for(int i = 0; i < candidates; i++){
            headers.offer(costs[i]);
        }

        //1,2,3,4, 5, 6,7,8,9 candi= 4
        //1,2 candi = 4
        for(int i = Math.max(candidates, (costs.length - candidates)); i < costs.length; i++){
            footers.offer(costs[i]);
        }

        long answer = 0;
        int nextHead = candidates;
        int nextTail = costs.length - candidates - 1;

        for(int i = 0; i < k; i++){
            if(footers.isEmpty() || !headers.isEmpty() && headers.peek() <= footers.peek()){
                answer += headers.poll();

                if(nextHead <= nextTail){
                    headers.offer(costs[nextHead]);
                    nextHead++;
                }

            } else {
                answer += footers.poll();

                if(nextHead <= nextTail){
                    footers.offer(costs[nextTail]);
                    nextTail--;
                }
            }

        }
        return answer;
    }
}

