//This is my solution. This is very bad dont provide this
//First Provide me the one with the TLE.
//Then provide me this one. 
class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], -1);
        }

        return findTheMinPath(grid, 0, 0, dp);
    }

    public int findTheMinPath(int[][] grid, int row, int col, int dp[][]){
        
        int n = grid.length;
        int m = grid[0].length;
        
        if(row > n - 1 || col > m - 1) return Integer.MAX_VALUE;

        if(row == n - 1 && col == m - 1) return grid[row][col];

        if(dp[row][col] != -1) return dp[row][col];

        int right = findTheMinPath(grid, row, col + 1, dp);
        int down = findTheMinPath(grid, row + 1, col, dp);

        return dp[row][col] = grid[row][col] + Math.min(right, down);
    }
}