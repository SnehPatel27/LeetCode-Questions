/*
This solution uses a breadth-first search (BFS) to explore the grid while tracking both the current position and the remaining obstacle eliminations. Here's a brief explanation:

State Representation:
Each state is represented as an array [row, col, remainingEliminations, steps], where:

row and col are the current coordinates.
remainingEliminations shows how many obstacles you can still remove.
steps is the number of moves taken so far.
Initialization:
The algorithm starts from the top-left corner (0,0) with k eliminations available and 0 steps. A visited 2D array is used to store the maximum number of eliminations remaining when reaching each cell. This ensures that if we revisit a cell, we only continue if we arrive with a higher remaining elimination count.

BFS Exploration:
For each state, the algorithm checks all four possible moves (up, right, down, left):

It verifies that the move is within grid boundaries.
It calculates the new remaining eliminations by subtracting the grid's value (0 for an empty cell, 1 for an obstacle).
If the new remaining eliminations are negative, that path is abandoned.
If the new state offers a better (higher) remaining elimination count than what was previously recorded for that cell, it is added to the BFS queue.
Goal Check:
If the bottom-right cell is reached, the algorithm immediately returns the number of steps taken. If no valid path is found after exploring all possibilities, it returns -1.
*/

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