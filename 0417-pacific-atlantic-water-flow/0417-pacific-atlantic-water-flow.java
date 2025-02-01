class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int rows = heights.length;
        int cols = heights[0].length;

        List<List<Integer>> result = new ArrayList<>();

        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];

        for(int i = 0; i < cols; i++){
            dfs(0, i, heights[0][i], pac, heights);
            dfs(rows - 1, i, heights[rows - 1][i], atl, heights);
        }

        for(int i = 0; i < rows; i++){
            dfs(i, 0, heights[i][0], pac, heights);
            dfs(i, cols - 1, heights[i][cols - 1], atl, heights);
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(pac[i][j] && atl[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }

        return result;

    }

    public void dfs(int row, int col, int prevHeight, boolean[][] visited, int[][] heights){

        if(row < 0 || row >= heights.length || col < 0 || col >= heights[0].length || visited[row][col] || prevHeight > heights[row][col]) return;

        visited[row][col] = true;

        dfs(row + 1, col, heights[row][col], visited, heights);
        dfs(row - 1, col, heights[row][col], visited, heights);
        dfs(row, col + 1, heights[row][col], visited, heights);
        dfs(row, col - 1, heights[row][col], visited, heights);
        
    }
}