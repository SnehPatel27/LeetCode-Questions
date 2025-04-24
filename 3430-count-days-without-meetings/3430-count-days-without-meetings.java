class Solution {
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