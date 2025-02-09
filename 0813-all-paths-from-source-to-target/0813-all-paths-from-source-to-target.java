class Solution {

    public void findAllPaths(List<List<Integer>> paths, List<Integer> temp, int source, int target, int[][] graph){

        if(source == target){
            paths.add(new ArrayList<>(temp));
            return; 
        }
        
        for(int neighbor: graph[source]){
            temp.add(neighbor);
            findAllPaths(paths, temp, neighbor, target, graph);
            temp.remove(temp.size() - 1);
        }
        
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> paths = new ArrayList<>();

        int n = graph.length;

        temp.add(0);

        findAllPaths(paths, temp, 0, n - 1, graph);

        return paths;
    }
}