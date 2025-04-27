class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int totalRows = grid.length;
        int totalCols = grid[0].length;

        boolean[][] visited = new boolean[totalRows][totalCols];

        int area = 0;
        for(int i = 0; i < totalRows; i++){
            for(int j = 0; j < totalCols; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    int currentArea = bfs(i, j, grid, visited);
                    area = Math.max(area, currentArea);
                }
            }
        }

        return area;
    }

    public int bfs(int row, int col, int[][] grid, boolean[][] visited){

        int count = 0;

        int totalRows = grid.length;
        int totalCols = grid[0].length;

        visited[row][col] = true;

        int[][] directions = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});

        while(!q.isEmpty()){
            int[] pair = q.poll();

            count++;

            int currRow = pair[0];
            int currCol = pair[1];

            for(int[] direction: directions){
                int newRow = currRow + direction[0];
                int newCol = currCol + direction[1];

                if(newRow >= 0 && newRow < totalRows && newCol >= 0 && newCol < totalCols && !visited[newRow][newCol] && grid[newRow][newCol] == 1){
                    visited[newRow][newCol] = true;
                    q.offer(new int[]{newRow, newCol});
                }
            }
        }

        return count;
    }
}