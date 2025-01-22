class Solution {

    //This is the solution with memoization. Provide me this as the second solution after recursion.
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];
        for(int i = 0; i < prices.length; i++){
            for(int j = 0; j < 2; j++){
                dp[i][j] = -1;
            }
        }
        return findMaxProfit(0, 1, prices, dp);
    }

    public int findMaxProfit(int index, int buy, int[] prices, int[][] dp){
        if(index == prices.length)
            return 0;

        int profit;
        if (dp[index][buy] != -1) return dp[index][buy];

        if(buy == 1){
            dp[index][buy] = Math.max(-prices[index] + findMaxProfit(index + 1, 0, prices, dp), 0 + findMaxProfit(index + 1, 1, prices, dp));
        } else {
            dp[index][buy] = Math.max(prices[index] + findMaxProfit(index + 1, 1, prices, dp), 0 + findMaxProfit(index + 1, 0, prices, dp));
        }

        return dp[index][buy];
    }
}