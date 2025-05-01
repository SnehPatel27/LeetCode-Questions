//This is the recursive solution

//This is the memoization solution
class Solution1 {
    public int minCostClimbingStairs(int[] cost) {
        
        int[] dp = new int[cost.length];

        Arrays.fill(dp, -1);
        
        int startAt0 = findMinCost(cost, 0, dp);
        int startAt1 = findMinCost(cost, 1, dp);

        return Math.min(startAt0, startAt1);
    }

    public int findMinCost(int[] cost, int index, int[] dp){
        
        if(index >= cost.length){
            return 0;
        }

        if(dp[index] != -1) return dp[index];

        int Step1Cost = cost[index] + findMinCost(cost, index + 1, dp);
        int Step2Cost = cost[index] + findMinCost(cost, index + 2, dp);

        return dp[index] = Math.min(Step1Cost, Step2Cost);
    }
}

//This is the tabulation solution
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int[] dp = new int[cost.length];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i < cost.length; i++){
            int Step1Cost = cost[i] + dp[i - 1];
            int Step2Cost = cost[i] + dp[i - 2];

            dp[i] = Math.min(Step1Cost, Step2Cost);
        }

        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}