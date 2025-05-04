class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for(int[] i: dp){
            Arrays.fill(i, -1);
        }
        return findWays(amount, coins, 0, dp);
    }

    public int findWays(int amount, int[] coins, int index, int[][] dp){

        if(index == coins.length){
            if(amount == 0){
                return 1;
            } else return 0;
        }

        if(dp[index][amount] != -1) return dp[index][amount];

        int notPick = findWays(amount, coins, index + 1, dp);
        int pick = 0;
        if(coins[index] <= amount){
            pick = findWays(amount - coins[index], coins, index, dp);
        }

        return dp[index][amount] = pick + notPick;
    }
}