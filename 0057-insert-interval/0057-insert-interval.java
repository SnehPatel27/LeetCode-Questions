class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> mergedInterval = new ArrayList<>();
        int i = 0;
        
        //Initially try adding all the intervals that are smaller than the newInterval.
        //Also check the condition that i is less the total length of interval
        while(i < n && intervals[i][1] < newInterval[0]){
            mergedInterval.add(intervals[i]);
            i++;
        }

        //Iterate now till there is merge in the intervals.
        //Keep on merging and then once merged add it to the final list. 
        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        mergedInterval.add(newInterval);

        //Now all the leftover elements in the intervals are greater than the newInterval so keep on adding them.
        while(i < n){
            mergedInterval.add(intervals[i]);
            i++;
        }

        return mergedInterval.toArray(new int[mergedInterval.size()][]);
    }
}