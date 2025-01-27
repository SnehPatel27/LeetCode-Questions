class Solution {

    //First give the recursive - memoization - dp

    //DP Solution
    public int climbStairss(int n) {
        if(n == 0 || n == 1){
            return 1;
        }
        int dp[] = new int[n+1];
        dp[0] = dp[1] = 1;
        
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    //Recursive Solution
    public int recursive(int n) {
        if(n == 0 || n == 1) return 1;

        int left = recursive(n - 1);
        int right = recursive(n - 2);

        return left + right;
    }

    
    //Memoization Solution
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return climbStairsHelper(n, dp);
    }

    public int climbStairsHelper(int n, int[] dp) {
        if(n == 0 || n == 1) return 1;

        if(dp[n] != -1) return dp[n];

        int left = climbStairsHelper(n - 1, dp);
        int right = climbStairsHelper(n - 2, dp);

        return dp[n] = left + right;
    }
}