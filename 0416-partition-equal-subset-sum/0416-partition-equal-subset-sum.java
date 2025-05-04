//This is the recursive solution
class Solution1 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int i = 0; i < n; i++){
            totalSum += nums[i];
        }

        if(totalSum % 2 != 0) return false;

        return canPartitionHelper(nums, n - 1, totalSum / 2);
    }

    public boolean canPartitionHelper(int[] nums, int index, int target){

        if(index == 0){
            if(target == 0 || nums[0] == target) return true;
            return false;
        }

        boolean notPick = canPartitionHelper(nums, index - 1, target);
        boolean pick = false;
        if(nums[index] <= target){
            pick = canPartitionHelper(nums, index - 1, target - nums[index]);
        }

        return pick || notPick;
    }
}

//This is the recursion with memoization solution
class Solution2 {
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

//This is the dp solution
public class Solution{
    public boolean canPartition(int[] nums) {
        
        int n = nums.length;
        int totalSum = 0;
        for(int i = 0; i < n; i++){
            totalSum += nums[i];
        }

        if(totalSum % 2 != 0) return false;

        int target = totalSum / 2;

        boolean[][] dp = new boolean[n][target + 1];

        for(int i = 0; i <= target; i++){
            if(i == 0 || nums[0] == i) dp[0][i] = true;
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j <= target; j++){
                boolean notPick = dp[i - 1][j];
                boolean pick = false;
                if(nums[i] <= j){
                    pick = dp[i - 1][j - nums[i]];
                }

                dp[i][j] = pick || notPick;
            }
        }
        return dp[n - 1][target];
    }
}