//This is the brute force Solution

//Here i am creating an adjList and then Calculating the height of each tree that can be formed. 
//If the helper function returned height of the tree is < height then clear the result list 
//If the helper function returned height of the tree is == height then add the node number to the result list.
//The helper function finds the height of the tree in the bottom up format. 

class Solution1 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        List<Integer> result = new ArrayList<>();
        int height = Integer.MAX_VALUE;
        int treeHeight = 0;
        for(int i = 0; i < n; i++){
            treeHeight = dfsHeight(i, -1, adjList);
            if(treeHeight < height){
                height = treeHeight;
                result.clear();
            }
            if(treeHeight == height){
                result.add(i);
            }
        }

        return result;
    }

    public int dfsHeight(int node, int prev, List<List<Integer>> adjList){
        int height = 0;
        for(int neighbor: adjList.get(node)){
            if(neighbor != prev){
                height = Math.max(height, dfsHeight(neighbor, node, adjList));
            }            
        }
        return height + 1;
    }
}

//There is another solution with the linear time complexity.
// We need to decrease the vertical length as much as possible so we can think of increasing the horizontal length to the max. So in this case when the horizontal length increases the leaf nodes would also increase. Think about 3 nodes which are placed in the same line and think about the same three nodes where 1 is the root and the rest 2 are its children. 
//So there is the conclusion that we maximize the leaf nodes. 
//Now we find the degrees of all the nodes and the ones with indegree 1 would be assumed and kept as leaf node. 
//We add all those in the queue and one by 1 we remove them and update the indegrees. 
//We keep on doing this till we get either 1 or 2 nodes that means that the output result size would be of size 1 or 2.
//The output result size can never be more than 2. 

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] degree = new int[n];
        List<Integer> result = new ArrayList<>();
        if(n == 1){
            result.add(0);
            return result;
        }


        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(degree[i] == 1){
                q.offer(i);
            }
        }
        int remainingNodes = n;
        while(remainingNodes > 2){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int node = q.poll();
                remainingNodes--;
                for(int neighbor: adjList.get(node)){
                    degree[neighbor]--;
                    if(degree[neighbor] == 1){
                        q.offer(neighbor);
                    }
                }
            }
        }

        
        while(!q.isEmpty()){
            result.add(q.poll());   
        }

        return result;
    }
}