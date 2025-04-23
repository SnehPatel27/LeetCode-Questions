class Solution1 {
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];

        for(int[] i: dp){
            Arrays.fill(i, -1);
        }

        int result = Integer.MAX_VALUE;
        int minFallingSum = 0;
        for(int i = 0; i < cols; i++){
            minFallingSum = dfs(matrix, 0, i, dp);
            result = Math.min(minFallingSum, result);
        }

        return result;
    }

    public int dfs(int[][] matrix, int row, int col, int[][] dp){
        int rows = matrix.length;
        int cols = matrix[0].length;

        if(row < 0 || row >= rows || col < 0 || col >= cols) return Integer.MAX_VALUE;

        if (row == rows - 1) return matrix[row][col];

        if(dp[row][col] != -1) return dp[row][col];

        int leftDiagonal = dfs(matrix, row + 1, col - 1, dp);
        int down = dfs(matrix, row + 1, col, dp);
        int rightDiagonal = dfs(matrix, row + 1, col + 1, dp);

        return dp[row][col] = matrix[row][col] + Math.min(leftDiagonal, Math.min(down, rightDiagonal));
    }
}

class Solution{
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];

        //First base case is in the first Row when you start you just start with the cell value for all cols. 
        for(int j = 0; j < cols; j++){
            dp[0][j] = matrix[0][j];
        }
        //After this the first row in the dp matrix would be filled so start with the next row for all cols one by one. 

        for(int i = 1; i < rows; i++){
            for(int j = 0; j < cols; j++){
                int up = matrix[i][j] + dp[i - 1][j];
                
                int leftUp = Integer.MAX_VALUE;
                if(j - 1 >= 0)
                    leftUp = matrix[i][j] + dp[i - 1][j - 1];
                
                int rightUp = Integer.MAX_VALUE;
                if(j + 1 < cols)
                    rightUp = matrix[i][j] + dp[i - 1][j + 1];

                dp[i][j] = Math.min(up, Math.min(leftUp, rightUp));
            }
        }

        int mini = Integer.MAX_VALUE;
        for(int j = 0; j < cols; j++){
            mini = Math.min(mini, dp[rows - 1][j]);
        }

        return mini;
    }
}