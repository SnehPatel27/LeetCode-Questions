class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        if(m == 1 && n == 1)
            return 0;

        Queue<int[]> q = new LinkedList<>();
        int visited[][] = new int[m][n];

        for(int[] row: visited){
            Arrays.fill(row, -1);
        }

        q.offer(new int[]{0, 0, k, 0});

        int[][] neighbors = new int[][]{{-1,0}, {0,1}, {1,0}, {0, -1}};

        while(!q.isEmpty()){
            int[] state = q.poll();

            int row = state[0];
            int col = state[1];
            int remain = state[2];
            int step = state[3];

            for(int i = 0; i < neighbors.length; i++){
                int neighborRow = row + neighbors[i][0];
                int neighborCol = col + neighbors[i][1];

                if(neighborRow < 0 || neighborRow >= m || neighborCol < 0 || neighborCol >=n){
                    continue;
                }

                if(neighborRow == m - 1 && neighborCol == n - 1)
                    return step + 1;
                
                int newRemain = remain - grid[neighborRow][neighborCol];

                if(newRemain < 0)
                    continue;
                
                if(remain > visited[neighborRow][neighborCol]){
                    visited[neighborRow][neighborCol] = newRemain;
                    q.offer(new int[]{neighborRow, neighborCol, newRemain, step + 1});
                }
            }
        }

        return -1;
    }
}