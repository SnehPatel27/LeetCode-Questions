class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int[] dp = new int[cost.length];

        Arrays.fill(dp, -1);
        
        int startAt0 = findMinCost(cost, cost.length, 0, dp);
        int startAt1 = findMinCost(cost, cost.length, 1, dp);

        System.out.println(startAt0);
        System.out.println(startAt1);

        return Math.min(startAt0, startAt1);
    }

    public int findMinCost(int[] cost, int n, int index, int[] dp){
        
        if(index >= n){
            return 0;
        }

        if(dp[index] != -1) return dp[index];

        int Step1Cost = cost[index] + findMinCost(cost, n, index + 1, dp);
        int Step2Cost = cost[index] + findMinCost(cost, n, index + 2, dp);

        return dp[index] = Math.min(Step1Cost, Step2Cost);
    }
}