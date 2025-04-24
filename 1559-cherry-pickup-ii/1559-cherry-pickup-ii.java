class Solution {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[] directions = new int[]{-1, 0, 1};

        int[][][] dp = new int[rows][cols][cols];

        for(int[][] i: dp){
            for(int[] j: i){
                Arrays.fill(j, -1);
            }
        }

        return cherryPickupsHelper(grid, 0, 0, cols - 1, directions, dp);
    }

    public int cherryPickupsHelper(int[][] grid, int row, int robot1Col, int robot2Col, int[] directions, int[][][] dp){

        int totalRows = grid.length;
        int totalColumns = grid[0].length;

        if(robot1Col < 0 || robot1Col >= totalColumns || robot2Col < 0 || robot2Col >= totalColumns){
            return Integer.MIN_VALUE;
        }

        if(row == totalRows - 1){
            if(robot1Col == robot2Col){
                return grid[row][robot1Col];
            } else {
                return grid[row][robot1Col] + grid[row][robot2Col];
            }
        }

        if(dp[row][robot1Col][robot2Col] != -1) return dp[row][robot1Col][robot2Col];
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                int value = 0;
                if(robot1Col == robot2Col){
                    value = grid[row][robot1Col] + cherryPickupsHelper(grid, row + 1, robot1Col + directions[i], robot2Col + directions[j], directions, dp);
                } else{
                    value = grid[row][robot1Col] + grid[row][robot2Col] + cherryPickupsHelper(grid, row + 1, robot1Col + directions[i], robot2Col + directions[j], directions, dp);
                }
                max = Math.max(value, max);
            }
        }

        return dp[row][robot1Col][robot2Col] = max;
    }
}