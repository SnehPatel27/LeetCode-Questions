class Solution {

    //First There would be a solution of TLE that I recently did. Show me that one.
    //Then Show me this solution of memoization
    //Then show me the one with DP that was submitted on 1st Novemember

    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount + 1];

        for(int i = 0; i < coins.length; i++){
            Arrays.fill(dp[i], -1);
        }

        int result = coinChangeHelper(coins.length - 1, amount, coins, dp);
        return result == Integer.MAX_VALUE ? -1:result;
    }

    public int coinChangeHelper(int index, int target, int[] coins, int[][] dp){

        if(index == 0){
            if(target % coins[index] == 0){
                return dp[index][target] = target/coins[index];
            } else return dp[index][target] = Integer.MAX_VALUE;
        }

        if (dp[index][target] != -1) return dp[index][target];

        int notTake = 0 + coinChangeHelper(index - 1, target, coins, dp);

        int take = Integer.MAX_VALUE;
        if(coins[index] <= target){
            int subResult = coinChangeHelper(index, target - coins[index], coins, dp);
            if(subResult != Integer.MAX_VALUE){
                take = 1 + subResult;
            }
        }

        return dp[index][target] = Math.min(take, notTake);
    }

    //If the constraints are simple and the coins[i] value is length and also the length of the coins is less
    //Then please provide me some other solution if applicable.
}