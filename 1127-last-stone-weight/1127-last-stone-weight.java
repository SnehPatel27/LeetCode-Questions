class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        int n = stones.length;

        for(int i = 0; i < n; i++){
            pq.offer(stones[i]);
        }

        while(pq.size() > 1){
            int firstStone = pq.poll();
            int secondStone = pq.poll();

            if(firstStone == secondStone){
                continue;
            }

            if(secondStone < firstStone){
                pq.offer(firstStone - secondStone);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}