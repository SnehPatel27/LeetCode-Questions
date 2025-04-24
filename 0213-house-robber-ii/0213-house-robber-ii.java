class Solution {
    public int robHelper(int[] nums) {
        int dp[] = new int[nums.length];
        
        dp[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            int notTake = 0 + dp[i - 1];
            int take = i > 1 ? dp[i - 2] + nums[i] : nums[i];

            dp[i] = Math.max(take, notTake);
        }

        return dp[nums.length - 1];
    }

    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];

        int[] temp1 = new int[n - 1];
        int[] temp2 = new int[n - 1];

        int counter1 = 0;
        int counter2 = 0;

        for(int i = 0; i < n; i++){
            if(i != 0){
                temp1[counter1++] = nums[i];
            } 

            if(i != n - 1){
                temp2[counter2++] = nums[i];
            }
        }

        return Math.max(robHelper(temp1), robHelper(temp2));
    }
}