class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        List<List<Integer>> adjList = new ArrayList<>();
        int totalNodes = graph.length;
        int[] indegree = new int[totalNodes];

        for(int i = 0; i < graph.length; i++){
            adjList.add(new ArrayList<>());
        }

        //Build the graph in reverse order. So it there i an edge incoming to 5 and no outgoing edges means it is a terminal Node. So now 5 would have the reverse outgoing edges and no incoming edges. 
        for(int i = 0; i < totalNodes; i++){
            for(int node: graph[i]){
                adjList.get(node).add(i);
                indegree[i]++;
            }
        }

        //Store the ones with no incoming edges in the new graph which is simply no outgoing edges in the original graph
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < totalNodes; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        boolean[] safeNodes = new boolean[totalNodes];

        //Keep on removing the indegree - 0 nodes and also remove edges that goes outwards from that node to other nodes and remove the indegree for those nodes and then store the ones whose indegree becomes zero. 
        while(!q.isEmpty()){
            int node = q.poll();
            safeNodes[node] = true;

            for(int neighbor: adjList.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    q.offer(neighbor);
                }
            }
        }

        //One possibiblty to sort could be directly sorting which would be nlogn. But in this case you use addtional O(n) boolean safeNodes array and additional O(n) TC to loop across that and store the result in sorted fashion. 
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < totalNodes; i++){
            if(safeNodes[i]){
                result.add(i);
            }
        }

        return result;
    }
}