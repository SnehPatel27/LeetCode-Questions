//This problem can be solved using dijkstra. Create initally a visited matrix and intialize everything to int max except the source cell that would be zero. The priority Queue would be consisting of distance, row, col. Keep on updating the distance matrix. When you reach the destination return the distance. But in this case instead of using a priority Queue and using the logn everytime to insert and remove from the queue you can just use a simple queue. Because in this case every cell with less distance would only enter the queue first and then the ones with larger distance so that minheap ordering of the distances would be maintained in this case just by using a normal queue. 
class Solution {

    public int[][] getneighbors(){
        return new int[][]{{-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}};
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if(grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0)
            return -1;

        Queue<int[]> q = new LinkedList<>();
        grid[0][0] = 1;
        q.offer(new int[]{0,0});

        while(!q.isEmpty()){
            int a[] = q.poll();
            int row = a[0];
            int col = a[1];

            int distance = grid[row][col];

            if(row == grid.length - 1 && col == grid[0].length - 1)
                return distance;

            for(int[] neighbors: findNeighbors(row, col, grid)){
                int neighborRow = neighbors[0];
                int neighborCol = neighbors[1];

                grid[neighborRow][neighborCol] = distance + 1;
                q.add(new int[]{neighborRow, neighborCol});

            }
        }

        return -1;
    }

    public List<int[]> findNeighbors(int row, int col, int[][] grid){

        List<int[]> neighbors = new ArrayList<>();

        for(int[] temp: getneighbors()){
            int newRow = row + temp[0];
            int newCol = col + temp[1];

            if(newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length || grid[newRow][newCol] != 0) continue;
        
        neighbors.add(new int[]{newRow, newCol});
        }

        return neighbors;
    }
}

/*  If told to dont use a seperate func to calc the neighbors and also not to modify the input matrix
class Solution {

    public int[][] getNeighbors() {
        return new int[][]{
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, 1}, {1, 1}, {1, 0},
            {1, -1}, {0, -1}
        };
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0)
            return -1;

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();

        // row, col, distance
        q.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0], col = cell[1], dist = cell[2];

            if (row == n - 1 && col == n - 1)
                return dist;

            for (int[] dir : getNeighbors()) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (isValid(newRow, newCol, grid, visited)) {
                    visited[newRow][newCol] = true;
                    q.offer(new int[]{newRow, newCol, dist + 1});
                }
            }
        }

        return -1;
    }

    public boolean isValid(int r, int c, int[][] grid, boolean[][] visited) {
        return r >= 0 && c >= 0 &&
               r < grid.length && c < grid[0].length &&
               grid[r][c] == 0 && !visited[r][c];
    }
}

*/