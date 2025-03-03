class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        List<Integer>[] adjacencyMatrix = new ArrayList[n];

        for(int i = 0; i < n; i++){
            adjacencyMatrix[i] = new ArrayList<>();
        }

        for(int edge[]: edges){
            adjacencyMatrix[edge[0]].add(edge[1]);
            adjacencyMatrix[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        return checkPath(adjacencyMatrix, source, destination, visited);
    }

    public boolean checkPath(List<Integer>[] adjacencyMatrix, int source, int destination, boolean[] visited){

        if(source == destination) return true;

        visited[source] = true;
        for(int i = 0; i < adjacencyMatrix[source].size(); i++){
            int newSource = adjacencyMatrix[source].get(i);
            if(!visited[newSource]){
                visited[newSource] = true;
                if(checkPath(adjacencyMatrix, newSource, destination, visited)){
                    return true;
                }
            }
        }

        return false;
    }
}