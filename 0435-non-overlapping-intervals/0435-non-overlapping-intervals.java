//My Approach
class Solution1 {
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

//Striver Approach
//In this you make the problem similar to N meeting room where you need to find out how many meetings can be conducted in a single room. So in that case you sort the entire arry with the end time and then you figure how many non overlapping intervals are there and this you would subtract from the total intervals length.
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1],b[1]));
        int length = intervals.length;
        int count = 1;
        int endTime = intervals[0][1];
        for(int i = 1; i < length; i++){
            if(intervals[i][0] >= endTime){
                count++;
                endTime = intervals[i][1];
            }
        }

        return length - count;
    }
}