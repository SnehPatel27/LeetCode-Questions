//This is the recursive solution
class Solution1 {
    public int rob(int[] nums) {
        return checkAdjacentElements(nums.length - 1, nums);
    }

    public int checkAdjacentElements(int index, int[] nums){
        if(index == 0) return nums[index];
        if(index < 0) return 0;

        int notPick = checkAdjacentElements(index - 1, nums);
        int pick = nums[index] + checkAdjacentElements(index - 2, nums);

        return Math.max(pick, notPick);
    }
}

//This is memoization
class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return checkAdjacentElements(nums.length - 1 , nums, dp);
    }

    public int checkAdjacentElements(int index, int[] nums, int[] dp){
        if(index == 0) return nums[index];
        if(index < 0) return 0;

        if(dp[index] != -1) return dp[index];

        int pick = nums[index] + checkAdjacentElements(index - 2, nums, dp);
        int notPick = checkAdjacentElements(index - 1, nums, dp);

        return dp[index] = Math.max(pick, notPick);
    }
}

//This is DP
class Solution2 {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        
        dp[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            int notTake = 0 + dp[i - 1];
            int take = i > 1 ? dp[i - 2] + nums[i] : nums[i];

            dp[i] = Math.max(take, notTake);
        }

        return dp[nums.length - 1];
    }
}

//In the final DP condition you can still space optimize this. You can observe that at each iteration you only require prev(i - 1) and prev2(i - 2). So instead of storing the entire dp array you can just keep track of the prev and prev2 variables. 