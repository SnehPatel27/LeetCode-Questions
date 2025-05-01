//The intuition used in this case it that in each cycle of n + 1 operations. We schedule each of the operation only once. So we iterate cycle by cycle till the queue is not empty. For each cycle we pop the elements from the queue till it does not become empty. The priority queue ensures that we first pick the element with the highest frequency. after popping element out and reducing its frequency by 1 we check if it is still greater then 1 meaning it still has tasks to process. If yes then at the end of the cycle we add it back to the priority Queue. After the end of the cycle we increment the time of the tasks by cycles. But at the very last iteration the time increments only by the number of tasks processed because the queue would become empty and there would not be any idle time in the last iteration.

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count the frequency of each task (A-Z)
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        // Step 2: Create a max heap (priority queue) to always pick the most frequent task
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        // Step 3: Add all non-zero frequencies to the heap
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0)
                pq.offer(freq[i]);
        }

        int time = 0; // Total time intervals needed to finish all tasks

        // Step 4: Process tasks in cycles of (n + 1)
        // Each cycle can schedule up to (n + 1) tasks (either actual or idle)
        while (!pq.isEmpty()) {
            int cycles = n + 1;             // Max tasks allowed in one cycle
            int taskCount = 0;              // Actual tasks done in this cycle
            List<Integer> temp = new ArrayList<>(); // Store tasks to be re-added after decreasing count

            // Step 5: Fill up this cycle with up to (n + 1) most frequent tasks
            while (cycles-- > 0 && !pq.isEmpty()) {
                int curr = pq.poll();       // Get the most frequent remaining task
                if (curr > 1) {
                    temp.add(curr - 1);     // Decrease frequency and store for re-adding
                }
                taskCount++;                // We did one task in this cycle
            }

            // Step 6: Add remaining tasks back into the heap
            for (int remaining : temp) {
                pq.offer(remaining);
            }

            // Step 7: Add time
            // - If no more tasks are left, only count actual tasks done (no idle needed)
            // - Else, a full cycle (n + 1) has passed, even if some were idle
            time += pq.isEmpty() ? taskCount : n + 1;
        }

        return time;
    }
}
