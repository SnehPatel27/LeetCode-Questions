//This is the DP solution
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

//This is the memoization Solution
class Solution1 {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        Arrays.fill(dp, -1);
        return findMostPoints(questions, 0, dp);   
    }

    public long findMostPoints(int[][] questions, int index, long[] dp){

        int n = questions.length;

        if(index == n - 1){
            return questions[index][0];
        }
        if(index >= n) return 0;

        if(dp[index] != -1) return dp[index];

        long notTake = findMostPoints(questions, index + 1, dp);
        long take = questions[index][0] + findMostPoints(questions, index + questions[index][1] + 1, dp);

        return dp[index] = Math.max(notTake, take);
    }
}

//This is the recrusive Solution
class Solution2 {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        return findMostPoints(questions, 0);   
    }

    public int findMostPoints(int[][] questions, int index){

        int n = questions.length;

        if(index == n - 1){
            return questions[index][0];
        }
        if(index >= n) return 0;

        int notTake = findMostPoints(questions, index + 1);
        int take = questions[index][0] + findMostPoints(questions, index + questions[index][1] + 1);

        return Math.max(notTake, take);
    }
}

