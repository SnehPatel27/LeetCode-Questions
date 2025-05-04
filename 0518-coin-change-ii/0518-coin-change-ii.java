class Solution1 {
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

//In order to get the dp solution for this case. Understand that the index is going from 0 to n - 1 in the memoization sulution so in this case it would go from n - 1 to 0. Amount goes from amount -> 0. So in the recursive soln it will go from 0 to amount. Then copy the recurrence as it is. For the base case understand that for all the indexes if the amount == 0. then there is just one way that not pick anything. 

//This is the DP solution 
public class Solution{
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];

        //Base Case: when the amount is zero there is just one way to achieve amount that is to pick nothing
        for(int i = 0; i < coins.length + 1; i++){
            dp[i][0] = 1;
        }

        for(int i = coins.length - 1; i >= 0; i--){
            for(int j = 0; j <= amount; j++){
                int notPick = dp[i + 1][j];
                int pick = 0;
                if(coins[i] <= j){
                    pick = dp[i][j - coins[i]];
                }
                dp[i][j] = pick + notPick;
            }
        }
        return dp[0][amount];
    }
}