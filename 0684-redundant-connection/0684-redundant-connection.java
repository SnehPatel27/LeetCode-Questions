class Solution1 {

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

// ---------------------------------------------------------------------------------------

class DisjointSet{
    int[] size;
    int[] parent;

    DisjointSet(int n){
        size = new int[n];
        parent = new int[n];

        for(int i = 0; i < n; i++){
            size[i] = 0;
            parent[i] = i;
        }
    }

    public int findParent(int node){
        if(node == parent[node]){
            return node;
        }

        int ultimateParent = findParent(parent[node]);
        parent[node] = ultimateParent;
        return ultimateParent;
    }

    public void union(int node1, int node2){
        int ultimateParentOf1 = parent[node1];
        int ultimateParentOf2 = parent[node2];

        if(ultimateParentOf1 == ultimateParentOf2){
            return;
        }

        if(size[ultimateParentOf2] > size[ultimateParentOf1]){
            parent[ultimateParentOf1] = ultimateParentOf2;
            size[ultimateParentOf2] += size[ultimateParentOf1];
        } else {
            parent[ultimateParentOf2] = ultimateParentOf1;
            size[ultimateParentOf1] += size[ultimateParentOf2];
        }
    }
}

class Solution{
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet ds = new DisjointSet(n + 1);
        for(int[] edge: edges){
            int node1 = edge[0];
            int node2 = edge[1];

            if(ds.findParent(node1) == ds.findParent(node2)){
                return edge;
            } else {
                ds.union(node1, node2);
            }
        }

        return new int[]{};
    }
}