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