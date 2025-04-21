class Pair{
    int height;
    int row;
    int col;
    int currentMaxHeight;

    Pair(int height, int row, int col, int currentMaxHeight){
        this.height = height;
        this.row = row;
        this.col = col;
        this.currentMaxHeight = currentMaxHeight;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {

        int totalRows = heights.length;
        int totalCols = heights[0].length;

        if(totalRows == 1 && totalCols == 1) return 0;

        int[][] visited = new int[totalRows][totalCols];

        for(int i = 0; i < totalRows; i++){
            for(int j = 0; j < totalCols; j++){
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        visited[0][0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.height - b.height);
        pq.offer(new Pair(0, 0, 0, 0));

        int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int height = p.height;
            int row = p.row;
            int col = p.col;
            int currentMaxHeight = p.currentMaxHeight;

            if(row == totalRows - 1 && col == totalCols - 1){
                return currentMaxHeight;
            }

            for(int[] neighbor: directions){
                int newRow = row + neighbor[0];
                int newCol = col + neighbor[1];

                if(newRow < 0 || newRow >= totalRows || newCol < 0 || newCol >= totalCols || Math.abs(heights[row][col] - heights[newRow][newCol]) >= visited[newRow][newCol]){
                    continue;
                }

                visited[newRow][newCol] = Math.abs(heights[row][col] - heights[newRow][newCol]);
                pq.offer(new Pair(visited[newRow][newCol], newRow, newCol, Math.max(currentMaxHeight, visited[newRow][newCol])));
            }
        }

        return -1;
    }
}