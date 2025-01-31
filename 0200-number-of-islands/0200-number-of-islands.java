import java.util.*;
class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int n=grid.length;
        int m=grid[0].length;
        int visited[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && grid[i][j] == '1'){
                    bfs(i, j, visited, grid);
                    //In case if the question demands using DFS travsersal 
                    //dfs(i, j, visited, grid);
                    count++;
                }
            }
        }
        return count;
    }
    public void bfs(int i, int j, int visited[][], char grid[][]){

        int n = grid.length;
        int m = grid[0].length;
        visited[i][j] = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(i,j));
        
        while(!q.isEmpty())
        {
            int new1 = q.peek().first;
            int new2 = q.peek().second;
            q.remove();
            int r[] = new int[]{-1, 0, 1, 0};
            int c[] = new int[]{0, 1, 0, -1};
            for(int x=0; x<r.length;x++){
                    int neighborrow = new1 + r[x];
                    int neighborcolumn = new2 + c[x];
                    if(neighborrow >=0 && neighborrow < n && neighborcolumn >=0 && neighborcolumn < m && visited[neighborrow][neighborcolumn]==0 && grid[neighborrow][neighborcolumn] == '1'){
                    visited[neighborrow][neighborcolumn] = 1;
                    q.add(new Pair(neighborrow, neighborcolumn));
                }
            }
        }
    }

    //IN case if the question demands using DFS Traversal 
    public void dfs(int i, int j, int visited[][], char grid[][]) {
        int n = grid.length;
        int m = grid[0].length;
        
        // Base conditions: Out of bounds or already visited or water
        if(i < 0 || i >= n || j < 0 || j >= m || visited[i][j] == 1 || grid[i][j] == '0') {
            return;
        }

        // Mark as visited
        visited[i][j] = 1;

        // Explore all four directions
        dfs(i - 1, j, visited, grid); // Up
        dfs(i + 1, j, visited, grid); // Down
        dfs(i, j - 1, visited, grid); // Left
        dfs(i, j + 1, visited, grid); // Right
    }
}