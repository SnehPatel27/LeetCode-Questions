class Solution1 {
    int n = 0, len=0;

    public int lengthOfLIS(int[] nums) {

        n = nums.length;
        int dp[][] = new int[nums.length][nums.length + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = -1;
            }
        }

        return providelength(0, -1, nums, dp, n);
    }

    public int providelength(int index, int prev, int nums[], int dp[][], int n) {

        if (index == n)
            return 0;
        if (dp[index][prev + 1] != -1)
            return dp[index][prev + 1];

        len = providelength(index + 1, prev, nums, dp, n);

        if (prev == -1 || nums[index] > nums[prev]) {
            len = Math.max(len, 1 + providelength(index + 1, index, nums, dp, n));
        }

        dp[index][prev + 1] = len;
        return dp[index][prev + 1];
    }
}

//This is the DP solution 
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int prev = index - 1; prev >= -1; prev--) {

                int notTake = dp[index + 1][prev + 1];
                int take = 0;

                if (prev == -1 || nums[index] > nums[prev]) {
                    take = 1 + dp[index + 1][index + 1];
                }

                dp[index][prev + 1] = Math.max(take, notTake);
            }
        }

        return dp[0][0];
    }
}


//This is the recursive solution. DO not provide me this function.
public class Solution2{
    public int lengthOfLIS(int[] nums){
        return provideLength(nums.length - 1, Integer.MAX_VALUE, nums);
    }

    public int provideLength(int index, int nextElement, int[] nums){

        if(index < 0) return 0;

        int len = provideLength(index - 1, nextElement, nums);
        if(nums[index] < nextElement){
            len = Math.max(len, 1 + provideLength(index - 1, nums[index], nums));
        }

        return len;
    }
}
