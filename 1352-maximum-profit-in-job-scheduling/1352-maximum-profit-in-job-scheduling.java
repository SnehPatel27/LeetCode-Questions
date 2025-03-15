class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        //Initially create a mapping of startTime, endTime, profit
        List<List<Integer>> intervals = new ArrayList<>();
        for(int i = 0; i < startTime.length; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(startTime[i]);
            temp.add(endTime[i]);
            temp.add(profit[i]);

            intervals.add(temp);
        }

        int dp[] = new int[intervals.size()];
        Arrays.fill(dp, -1);

        //Sort this mapping with respect to the start time
        intervals.sort(Comparator.comparingInt(a -> a.get(0)));

        return findMaxProfit(0, intervals, dp);
    }

    public int findMaxProfit(int n, List<List<Integer>> intervals, int[] dp){
        if(n == intervals.size()){
            return 0;
        }
        
        if(dp[n] != -1) return dp[n];

        //This is the case when you dont take the job
        int excludeProfit = findMaxProfit(n + 1, intervals, dp);

        
        int startInterval = intervals.get(n).get(0);
        int endInterval = intervals.get(n).get(1);
        int profitInterval = intervals.get(n).get(2);

        //In case if you pick a job you need to figure out the next job that you can pick.
        //Here you case that which job has the start time >= currentJob.
        //That would be your j.
        
        // int j = n + 1;

        //This solution of using while loop to check for the next available job takes n square time. 
        //It is better to use binary search to predict the next greater element.
       
        // while(j < intervals.size()){
        //     if(intervals.get(j).get(0) >= endInterval){
        //         break;
        //     }
        //     j += 1;
        // }

        int j = findNextAvailableJob(intervals, n);
        
        //This is the case when you take the job
        int includeProfit = profitInterval + findMaxProfit(j, intervals, dp);

        return dp[n] = Math.max(includeProfit, excludeProfit);
    }

    public int findNextAvailableJob(List<List<Integer>> intervals, int n){
        int low = n + 1;
        int high = intervals.size() - 1;

        int result = intervals.size();

        while(low <= high){
            int mid = (low + high) / 2;
            if(intervals.get(n).get(1) > intervals.get(mid).get(0)){
                low = mid + 1;
            } else if(intervals.get(n).get(1) <= intervals.get(mid).get(0)){
                result = mid;
                high = mid - 1;    
            }
        }

        return result;
    }
}