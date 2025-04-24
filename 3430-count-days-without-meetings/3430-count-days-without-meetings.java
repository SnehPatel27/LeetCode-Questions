//This is my solution.
class Solution1 {
    public int countDays(int days, int[][] meetings) {
        List<int[]> mergedMeetings = new ArrayList<>();

        Arrays.sort(meetings, (a,b) -> Integer.compare(a[0], b[0]));

        for(int[] meeting: meetings){
            if(mergedMeetings.isEmpty() || mergedMeetings.get(mergedMeetings.size() - 1)[1] < meeting[0]){
                mergedMeetings.add(meeting);
            } else {
                mergedMeetings.get(mergedMeetings.size() - 1)[1] = Math.max(mergedMeetings.get(mergedMeetings.size() - 1)[1], meeting[1]);
            }
        }

        int totalMeetingDays = 0;
        for(int a[]: mergedMeetings){
            totalMeetingDays += a[1] - a[0] + 1;
        }

        return days - totalMeetingDays;
    }
}

//This is optimal Solution. Provide this one.
class Solution {
    public int countDays(int days, int[][] meetings) {
        List<int[]> mergedMeetings = new ArrayList<>();

        int lastEndTime = 0;
        int freeDays = 0;

        Arrays.sort(meetings, (a,b) -> Integer.compare(a[0], b[0]));

        for(int[] meeting: meetings){
            
            int start = meeting[0];
            int end = meeting[1];

            if(start > lastEndTime + 1){
                freeDays += start - lastEndTime - 1;
            }

            lastEndTime = Math.max(lastEndTime, end);
        }

        freeDays += days - lastEndTime;
        return freeDays;
    }
}