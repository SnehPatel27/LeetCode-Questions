//There are two possibilities for doing this question. One approach is to start bfs from all the 1s and then update the result matrix accordingly. In that case lets assume in the worst case all the cells are 1 except 1 - 0 in the far corner. So all the cells would have to be traversed for each 1 approx. So the complexity becomes (n * m) square. 

//The second approach is to store all the 0s in the queue and run the bfs parellely for them. This would ensure that each of the cell would be visited only once and the complexity would become linear. 
class Pair{
    int row;
    int col;

    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        int[][] result = new int[rows][cols];

        boolean[][] visited = new boolean[rows][cols];

        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(mat[i][j] == 0){
                    visited[i][j] = true;
                    q.offer(new Pair(i, j));
                }
            }
        }

        int counter = 0;
        while(!q.isEmpty()){

            int size = q.size();
            counter++;

            for(int i = 0; i < size; i++){
                Pair p = q.poll();
                int currentRow = p.row;
                int currentCol = p.col;

                for(int[] direction: directions){
                    int newRow = currentRow + direction[0];
                    int newCol = currentCol + direction[1];

                    if(newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols){
                        continue;
                    }

                    if(mat[newRow][newCol] == 1 && !visited[newRow][newCol]){
                        visited[newRow][newCol] = true;
                        result[newRow][newCol] = counter;
                        q.offer(new Pair(newRow, newCol));
                    }
                }
            }
        }  

        return result; 
    }
}