class Solution {
    public long mostPoints(int[][] questions) {

        int n = questions.length;

        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);

        dp[n] = 0;

        for(int i = n - 1; i >= 0; i--){
            
            int points = questions[i][0];
            int steps = questions[i][1];

            long notTake = dp[i + 1];
            long take = 0;
            if(i + steps + 1 <= n) 
                take = points + dp[i + steps + 1];
            else take = points;

            dp[i] = Math.max(take, notTake);
        }

        return dp[0];
    }
}