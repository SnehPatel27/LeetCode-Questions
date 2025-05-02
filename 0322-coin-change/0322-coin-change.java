//This is the recursion with memoization solution.
class Solution1 {

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
}

//This is the DP solution
public class Solution{
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount + 1];

        for(int i = 0; i < amount + 1; i++){
            if(i % coins[0] == 0){
                dp[0][i] = i / coins[0];
            } else{
                dp[0][i] = Integer.MAX_VALUE;
            }
        }

        for(int i = 1; i < coins.length; i++){
            for(int j = 0; j < amount + 1; j++){
                int notTake = dp[i - 1][j];

                int take = Integer.MAX_VALUE;
                if(coins[i] <= j){
                    int subResult = dp[i][j - coins[i]];
                    if(subResult != Integer.MAX_VALUE){
                        take = 1 + subResult;
                    }
                }
                dp[i][j] = Math.min(take, notTake);
            }
        }

        return dp[coins.length - 1][amount] == Integer.MAX_VALUE ? -1 : dp[coins.length - 1][amount];
    }
}
