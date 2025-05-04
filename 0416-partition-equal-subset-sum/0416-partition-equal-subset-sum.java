class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int i = 0; i < n; i++){
            totalSum += nums[i];
        }

        if(totalSum % 2 != 0) return false;

        int[][] dp = new int[n][totalSum];

        for(int[] i: dp){
            Arrays.fill(i, -1);
        }

        return canPartitionHelper(nums, n - 1, totalSum / 2, dp) == 1 ? true : false;
    }

    public int canPartitionHelper(int[] nums, int index, int target, int[][] dp){

        if(index == 0){
            if(target == 0 || nums[0] == target) return 1;
            return 0;
        }

        if(dp[index][target] != -1) return dp[index][target];

        int notPick = canPartitionHelper(nums, index - 1, target, dp);
        int pick = 0;
        if(nums[index] <= target){
            pick = canPartitionHelper(nums, index - 1, target - nums[index], dp);
        }

        return dp[index][target] = Math.max(pick, notPick);
    }
}