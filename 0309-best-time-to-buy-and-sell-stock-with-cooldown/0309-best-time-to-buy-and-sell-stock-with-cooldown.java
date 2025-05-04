class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] i: dp){
            Arrays.fill(i, -1);   
        }
        return findMaxProfit(prices, 0, 1, dp);
    }

    public int findMaxProfit(int[] prices, int index, int buy, int[][] dp){

        if(index >= prices.length) return 0;

        if(dp[index][buy] != -1) return dp[index][buy];

        if(buy == 1){
            int option1 = -prices[index] + findMaxProfit(prices, index + 1, 0, dp);
            int option2 = findMaxProfit(prices, index + 1, 1, dp);

            return dp[index][buy] = Math.max(option1, option2);
        } else {
            int option1 = prices[index] + findMaxProfit(prices, index + 2, 1, dp);
            int option2 = findMaxProfit(prices, index + 1, 0, dp);

            return dp[index][buy] = Math.max(option1, option2);
        }
    }
}