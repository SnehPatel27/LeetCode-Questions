//This is the recursive Solution
class Solution1 {
    public int uniquePaths(int m, int n) {
        return generateUniquePaths(m, n, 0, 0);
    }

    public int generateUniquePaths(int m, int n, int currRow, int currCol){
        
        if(currRow < 0 || currRow >= m || currCol < 0 || currCol >= n){
            return 0;
        }
        
        if(currRow == m - 1 && currCol == n - 1){
            return 1;
        }

        int down = generateUniquePaths(m, n, currRow + 1, currCol);
        int right = generateUniquePaths(m, n, currRow, currCol + 1);

        return down + right;
    }
}

//This is the memoization Solution
class Solution {
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        for(int[] rows: dp){
            Arrays.fill(rows, -1);
        }

        return generateUniquePaths(m, n, 0, 0, dp);
    }

    public int generateUniquePaths(int m, int n, int currRow, int currCol, int[][] dp){
        
        if(currRow < 0 || currRow >= m || currCol < 0 || currCol >= n){
            return 0;
        }
        
        if(currRow == m - 1 && currCol == n - 1){
            return 1;
        }

        if(dp[currRow][currCol] != -1) return dp[currRow][currCol];

        int down = generateUniquePaths(m, n, currRow + 1, currCol, dp);
        int right = generateUniquePaths(m, n, currRow, currCol + 1, dp);

        return dp[currRow][currCol] = down + right;
    }
}

//This is the DP solution
class Solution2 {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        dp[0][0] = 1;
        for(int i=1;i<n;i++){
            dp[0][i] = 1;
        }
        for(int i=1;i<m;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}