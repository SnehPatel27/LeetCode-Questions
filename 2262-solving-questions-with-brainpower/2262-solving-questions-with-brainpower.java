class Solution {
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