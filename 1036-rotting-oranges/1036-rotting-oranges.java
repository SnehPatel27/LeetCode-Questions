class Pair{
    int row;
    int col;
    int time;
    Pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] visited = new int[rows][cols];
        int freshCount = 0;

        Queue<Pair> que = new LinkedList<>();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 2){
                    visited[i][j] = 2;
                    que.add(new Pair(i, j, 0));
                }else{
                    visited[i][j] = 0;
                }

                if(grid[i][j] == 1) freshCount++;
            }
        }

        int[] r = new int[]{-1, 0, 1, 0};
        int[] c = new int[]{0, 1, 0, -1};
        int t = 0, count = 0;

        while(!que.isEmpty()){
            int currentRow = que.peek().row;  
            int currentCol = que.peek().col;
            t = que.peek().time;
            que.poll();

            for(int j = 0; j < 4; j++){
                int neighborRow = currentRow + r[j];
                int neighborCol = currentCol + c[j];

                if(neighborRow >= 0 && neighborRow < rows && neighborCol >= 0 && neighborCol < cols && visited[neighborRow][neighborCol] == 0 && grid[neighborRow][neighborCol] == 1){
                    visited[neighborRow][neighborCol] = 2;
                    que.add(new Pair(neighborRow, neighborCol, t + 1));
                    count++;
                }
            }
        }

        if(freshCount == count) return t;
        else return -1;
    }
}

/* Time Complexity - For each cell, you check its 4 neighbors. In the worst case, for all m × n cells, you perform 4 × (m × n) operations. Also O(M*N) to count the number of fresh and rotten oranges initially. 

Space Complexity - Visited Array: O(m × n), Queue: O(m × n) */