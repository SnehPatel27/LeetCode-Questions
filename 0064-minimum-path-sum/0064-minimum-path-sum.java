class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];

        for(int i = 0; i < n; i++){
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }

        findTheMinPath(grid, 0, 0, visited, grid[0][0]);

        return visited[n - 1][m - 1];
    }

    public void findTheMinPath(int[][] grid, int row, int col, int[][] visited, int currentPathSum){
        
        int n = grid.length;
        int m = grid[0].length;

        if(n == 1 && m == 1){
           visited[row][col] = grid[row][col];
            return;
        }

        if(currentPathSum < visited[row][col]){
            visited[row][col] = currentPathSum;
        } else {
            return;
        }

        int[] nRow = new int[]{0, 1};
        int[] nCol = new int[]{1, 0};

        for(int i = 0; i < nRow.length; i++){
            int newRow = row + nRow[i];
            int newCol = col + nCol[i];

            if(newRow < 0 || newRow > n - 1 || newCol < 0 || newCol > m - 1){
                continue;
            }

            findTheMinPath(grid, newRow, newCol, visited, currentPathSum + grid[newRow][newCol]);
        }
    }
}