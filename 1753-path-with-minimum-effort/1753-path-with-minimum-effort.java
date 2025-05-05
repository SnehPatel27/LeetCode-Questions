// Helper class to store each cell's data for priority queue
class Pair {
    int height; // max effort (difference) to reach this cell from source
    int row, col;

    Pair(int height, int row, int col) {
        this.height = height;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int totalRows = heights.length;
        int totalCols = heights[0].length;

        // Base case: already at the destination
        if (totalRows == 1 && totalCols == 1) return 0;

        // visited[r][c] stores the minimum effort to reach (r, c)
        int[][] visited = new int[totalRows][totalCols];

        // Initialize all cells as unvisited (infinite effort)
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        // Starting point (0, 0) with 0 effort
        visited[0][0] = 0;

        // Min-heap based on effort (minimize maximum difference so far)
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.height - b.height);
        pq.offer(new Pair(0, 0, 0)); // {effort, row, col}

        // Four directions: up, right, down, left
        int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int height = p.height;
            int row = p.row;
            int col = p.col;

            // If we've reached the bottom-right cell, return the effort
            if (row == totalRows - 1 && col == totalCols - 1) {
                return height;
            }

            // Explore neighbors
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check boundaries
                if (newRow >= 0 && newRow < totalRows && newCol >= 0 && newCol < totalCols) {
                    // Calculate effort to move to (newRow, newCol)
                    int currentEffort = Math.abs(heights[row][col] - heights[newRow][newCol]);
                    // Max of effort so far and this edge's effort
                    int maxEffort = Math.max(currentEffort, height);

                    // If this path offers a smaller effort, update and push to queue
                    if (maxEffort < visited[newRow][newCol]) {
                        visited[newRow][newCol] = maxEffort;
                        pq.offer(new Pair(maxEffort, newRow, newCol));
                    }
                }
            }
        }

        // This should never be reached as the destination is always reachable
        return -1;
    }
}
