class Solution {
    public int minFlips(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;

        int rowCount = 0;
        int colCount = 0;

        //Go across all rows
        for(int i = 0; i < rows; i++){
            int start = 0;
            int end = cols - 1;

            while(start < end){
                if(grid[i][start] != grid[i][end]){
                    rowCount++;
                }
                start++;
                end--;
            }
        }

        //Go across all cols
        for(int i = 0; i < cols; i++){
            int start = 0;
            int end = rows - 1;

            while(start < end){
                if(grid[start][i] != grid[end][i]){
                    colCount++;
                }
                start++;
                end--;
            }
        }

        return Math.min(rowCount, colCount);
    }
}