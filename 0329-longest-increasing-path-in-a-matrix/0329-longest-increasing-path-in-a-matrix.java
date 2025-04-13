//This is the brute force solution where traverse each cell and for that cell I explore what is the max sequence length I can go and this take (m * n) ^ 2 time complexity.
class Solution1 {
    
    int[][] neighbors = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        
        int increasingSequence = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                increasingSequence = Math.max(increasingSequence, dfs(i, j, matrix));
            }
        }

        return increasingSequence;
    }

    public int dfs(int row, int col, int[][] matrix){

        int height = 1;
        for(int[] neighbor: neighbors){
            int newRow = row + neighbor[0];
            int newCol = col + neighbor[1];           

            if(newRow < 0 || newRow >= matrix.length || newCol < 0 || newCol >= matrix[0].length){
                continue;
            }

            if(matrix[newRow][newCol] > matrix[row][col]){
                height = Math.max(height, 1 + dfs(newRow, newCol, matrix)); 
            }
        }   

        return height;
    }
}


//This is the solution with Memoization
class Solution {
    
    int[][] neighbors = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;

        int increasingSequence = 0;

        int dp[][] = new int[n][m];

        for(int i[]: dp){
            Arrays.fill(i, -1);
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                increasingSequence = Math.max(increasingSequence, dfs(i, j, matrix, dp));
            }
        }

        return increasingSequence;
    }

    public int dfs(int row, int col, int[][] matrix, int[][] dp){

        int height = 1;

        if(dp[row][col] != -1) return dp[row][col];

        for(int[] neighbor: neighbors){
            int newRow = row + neighbor[0];
            int newCol = col + neighbor[1];           

            if(newRow < 0 || newRow >= matrix.length || newCol < 0 || newCol >= matrix[0].length){
                continue;
            }

            if(matrix[newRow][newCol] > matrix[row][col]){
                height = Math.max(height, 1 + dfs(newRow, newCol, matrix, dp)); 
            }
        }   

        return dp[row][col] = height;
    }
}