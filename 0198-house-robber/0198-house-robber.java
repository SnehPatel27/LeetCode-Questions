class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            dp[i] = -1;
        }
        return checkAdjacentElements(0 , nums, dp);
    }

    public int checkAdjacentElements(int index, int[] nums, int[] dp){
        if(index >= nums.length) return 0;

        if(dp[index] != -1) return dp[index];

        int pick = nums[index] + checkAdjacentElements(index + 2, nums, dp);
        int notPick = checkAdjacentElements(index + 1, nums, dp);

        return dp[index] = Math.max(pick, notPick);
    }
}