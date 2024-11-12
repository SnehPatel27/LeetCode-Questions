class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int j[]: prerequisites){
            int course = j[0];
            int pre = j[1];

            adj.get(pre).add(course);
        }

        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            for(int j: adj.get(i)){
                indegree[j]++;
            }
        }

        Queue<Integer> que = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) que.add(i);
        }

        int[] topoSort = new int[numCourses];
        int i = 0;
        while(!que.isEmpty()){
            int num = que.peek();
            que.remove();

            topoSort[i++] = num;

            for(int j: adj.get(num)){
                indegree[j]--;
                if(indegree[j] == 0) que.add(j);
            }
        }
        
        if(i == numCourses) return topoSort;

        return new int[0];
    }
}