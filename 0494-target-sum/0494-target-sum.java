//This question is similar to creating two partitions whose difference is target. 
//For example Partition 1 can have 1,1,1,1 and partition 2 can have 1. 
//Difference is 3 which is equal to target. This is one of the way. 
//There are 5 ways in doing this to ans is 5. 
//So this question is transformed to count total partitions with difference target. 

//Lets say the sum of two partitions are s1 and s2.
//such that s1 - s2 = target. Something we have to find. 
//s1 can be written as totalSum - s2. 
//we get s2 = (totalSum - target) / 2.
//So basically we need to find the total ways to generate sum of TotalSum - target / 2.
//Hence again the question is split down to count total subsets with sum = k where k is...

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for(int i = 0; i < nums.length; i++){
            totalSum += nums[i];
        }

        if(totalSum - target < 0 || ((totalSum - target) % 2) != 0) return 0;
        int newTarget = (totalSum - target) / 2;

        int[][] dp = new int[nums.length][newTarget + 1];

        for(int[] rows: dp){
            Arrays.fill(rows, -1);
        }

        return countTotalWays(nums, newTarget, nums.length - 1, dp);
    }

    public int countTotalWays(int[] nums, int target, int index, int[][] dp){
        if(index == 0){
            if(target == 0 && nums[index] == 0) return 2;
            if(target == 0 || nums[index] == target) return 1;
            return 0;
        }

        if(dp[index][target] != -1) return dp[index][target];

        int notTake = countTotalWays(nums, target, index - 1, dp);
        int take = 0;
        if(nums[index] <= target){
            take = countTotalWays(nums, target - nums[index], index - 1, dp);
        }

        return dp[index][target] = take + notTake;
    
    }
}