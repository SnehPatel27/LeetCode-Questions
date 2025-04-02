class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));
        int length = intervals.length;
        int i = 0;
        int count = 0;
        while(i < length){
            int start = intervals[i][0];
            int end = intervals[i][1];

            while(i + 1 < length && (intervals[i + 1][0] < end)){
                end = Math.min(end, intervals[i + 1][1]);
                count++;
                i++;
            }
            i++;
        }

        return count;
    }
}