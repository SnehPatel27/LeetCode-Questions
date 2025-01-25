class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c: tasks){
            freq[c - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b,a));

        for(int i = 0; i < 26; i++){
            if(freq[i] > 0)
                pq.offer(freq[i]);
        }
        int time = 0;
        while(!pq.isEmpty())
        {
            int cycles = n + 1;
            int taskCount = 0;
            List<Integer> temp = new ArrayList<>();
            while(cycles-- > 0 && !pq.isEmpty()){
                int first = pq.poll();
                if(first > 1)
                    temp.add(first - 1);

                taskCount++;
            }
            temp.forEach(pq::offer);
            time += (pq.isEmpty() ? taskCount : n + 1);   
        }
        return time;
    }
}