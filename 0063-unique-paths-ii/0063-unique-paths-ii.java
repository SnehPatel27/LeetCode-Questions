class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        for(int[] i: dp){
            Arrays.fill(i, -1);
        }
        return findUniquePaths(0, 0, dp, obstacleGrid);
    }

    public int findUniquePaths(int row, int col, int[][] dp, int[][] obstacleGrid){
        if(row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1 && obstacleGrid[row][col] != 1){
            return 1;
        }

        if(row < 0 || col < 0 || row >= obstacleGrid.length || col >= obstacleGrid[0].length || obstacleGrid[row][col] == 1)
            return 0;

        if(dp[row][col] != -1)
            return dp[row][col];

        int right = findUniquePaths(row, col + 1, dp, obstacleGrid);
        int down = findUniquePaths(row + 1, col, dp, obstacleGrid);

        return dp[row][col] = right + down;
    }
}