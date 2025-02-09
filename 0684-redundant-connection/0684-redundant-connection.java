class Solution {

    public boolean isConnected(int source, int target, boolean[] visited, List<Integer>[] adj){

        visited[source] = true;

        if(source == target)
            return true;

        boolean isFound = false;
        for(int neighbor: adj[source]){
            if(!visited[neighbor]){
                if(isConnected(neighbor, target, visited, adj)){
                    return true;
                }
            }
        }

        return isFound;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        List<Integer>[] adj = new ArrayList[n];

        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] edge: edges){
            boolean[] visited = new boolean[n];

            int source = edge[0] - 1;
            int target = edge[1] - 1;

            System.out.println(source + " " + target);

            if(isConnected(source, target, visited, adj)){
                return new int[]{edge[0], edge[1]};
            }
            
            adj[source].add(target);
            adj[target].add(source);
        }

        return new int[]{};
    }
}