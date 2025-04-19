class Solution {

    public void dfs(char[][] board, int row, int col, int[][] visited, int[] dx, int[] dy){
        int totalRows = board.length;
        int totalCols = board[0].length;
        
        visited[row][col] = 1;

        for(int i = 0; i < 4; i++){
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            if(newRow >= totalRows || newRow < 0 || newCol < 0 || newCol >= totalCols){
                continue;
            }

            if(board[newRow][newCol] == 'O' && visited[newRow][newCol] == 0){
                dfs(board, newRow, newCol, visited, dx, dy);
            }
        }
        return;
    }

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] visited = new int[rows][cols];

        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        for(int i = 0; i < rows; i++){

            //For the first Col
            if(visited[i][0] == 0 && board[i][0] == 'O'){
                System.out.println("DFS call");
                dfs(board, i, 0, visited, dx, dy);
            }

            //For the last Col
            if(visited[i][cols - 1] == 0 && board[i][cols - 1] == 'O'){
                System.out.println("DFS call");
                dfs(board, i, cols - 1, visited, dx, dy);
            }
        }

        for(int j = 0; j < cols; j++){

            //For the first Row
            if(visited[0][j] == 0 && board[0][j] == 'O'){
                System.out.println("DFS call");
                dfs(board, 0, j, visited, dx, dy);
            }

            //For the last Row
            if(visited[rows - 1][j] == 0 && board[rows - 1][j] == 'O'){
                System.out.println("DFS call");
                dfs(board, rows - 1, j, visited, dx, dy);
            }
        }

        //Change the ones that are surrounded
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'O' && visited[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }
    }
}