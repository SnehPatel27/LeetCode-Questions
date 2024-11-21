class Solution {
    private int count = 0;
    public int combinationSum4(int[] nums, int target) {
        
        int dp[] = new int[target + 1];

        dp[0] = 1;

        for(int t = 1; t <= target; t++){
            for(int num: nums){
                if(t >= num){
                    dp[t] += dp[t - num];
                }
            }
        }

        return dp[target];
    }
}