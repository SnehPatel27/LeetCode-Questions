class Solution {

    public void dfs(int[][] grid, int[][] visited, int row, int col, int[] dx, int[] dy){
    
        visited[row][col] = 1;

        int rows = grid.length;
        int cols = grid[0].length;

        for(int i = 0; i < 4; i++){
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && visited[newRow][newCol] != 1 && grid[newRow][newCol] == 1){
                dfs(grid, visited, newRow, newCol, dx, dy);
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] visited = new int[rows][cols];

        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        for(int i = 0; i < rows; i++){

            //First Col
            if(grid[i][0] == 1 && visited[i][0] == 0){
                dfs(grid, visited, i, 0, dx, dy);
            }

            //Last Col
            if(grid[i][cols - 1] == 1 && visited[i][cols - 1] == 0){
                dfs(grid, visited, i, cols - 1, dx, dy);
            }
        }

        for(int j = 0; j < cols; j++){

            //First Row
            if(grid[0][j] == 1 && visited[0][j] == 0){
                dfs(grid, visited, 0, j, dx, dy);
            }

            //Last Row
            if(grid[rows - 1][j] == 1 && visited[rows - 1][j] == 0){
                dfs(grid, visited, rows - 1, j, dx, dy);
            }
        }

        int counter = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    counter++;
                }
            }
        }

        return counter;
    }
}