class Solution {
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    for(int[] direction: directions){
                        int newRow = i + direction[0];
                        int newCol = j + direction[1];

                        if(newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length || grid[newRow][newCol] == 0)
                            count++;
                    }
                }
            }
        }
        return count;
    }
}