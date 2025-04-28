class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        List<List<Integer>> adjList = new ArrayList<>();
        int totalNodes = graph.length;
        for(int i = 0; i < graph.length; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < totalNodes; i++){
            int[] edge = graph[i];
            for(int j = 0; j < edge.length; j++){
                int source = edge[j];
                adjList.get(source).add(i);
            }
        }

        int[] indegree = new int[totalNodes];
        for(int i = 0; i < totalNodes; i++){
            indegree[i] = graph[i].length;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < totalNodes; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            result.add(node);

            for(int neighbor: adjList.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    q.offer(neighbor);
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}