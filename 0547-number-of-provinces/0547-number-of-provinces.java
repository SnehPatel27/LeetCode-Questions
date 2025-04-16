class Solution {
    public int findCircleNum(int[][] isConnected) {
        int nodes = isConnected.length;
        boolean[] visited = new boolean[nodes];
        int province = 0;
        for(int i = 0; i < nodes; i++){
            if(!visited[i]){
                bfs(i, isConnected, visited);
                province++;
            }
        }

        return province;
    }

    public void bfs(int node, int[][] connected, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        int cols = connected[0].length;            
        q.offer(node);

        while(!q.isEmpty()){

            int size = q.size();

            for(int i = 0; i < size; i++){
                int currentNode = q.poll();
                for(int neighbors = 0; neighbors < cols; neighbors++){
                    if(connected[currentNode][neighbors] == 1 && visited[neighbors] == false){
                        visited[neighbors] = true;
                        q.offer(neighbors);
                    }
                }
            }
        }
    }
}