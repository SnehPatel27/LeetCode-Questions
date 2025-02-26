class Solution {
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    count += getPerimeter(i, j, grid);
                }
            }
        }
        return count;
    }

    public int getPerimeter(int row, int col, int[][] grid){
        int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int count = 0;
        for(int[] direction: directions){
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if(newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length)
                continue;
            
            if(grid[newRow][newCol] == 1) count++;
        }

        return 4 - count;
    }
}