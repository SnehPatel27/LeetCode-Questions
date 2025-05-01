//This is the recursive solution

//This is the memoization solution
class Solution {
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
