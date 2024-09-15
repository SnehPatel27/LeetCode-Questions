class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        // List<List<Integer>> result = new ArrayList<>();
        List<int[]> result = new ArrayList<>();

        // Arrays.sort(intervals, new Comparator<int[]>(){
        //     public int compare(int a[], int b[]){
        //         return Integer.compare(a[0], b[0]);
        //     }
        // });

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        for(int i=0;i<n;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(!result.isEmpty() && result.get(result.size() - 1)[1] >= end){
                continue;
            }

            for(int j=i+1;j<n;j++){
                if(end >= intervals[j][0]){
                    end = Math.max(end, intervals[j][1]);
                }else{
                    break;
                }
            }
            result.add(new int[]{start, end});
        }

        return result.toArray(new int[result.size()][]);   
    }
}