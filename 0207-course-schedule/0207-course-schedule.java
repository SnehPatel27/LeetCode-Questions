class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adjacency = new ArrayList<>();

        //Initialize an array
        for(int i = 0; i < numCourses; i++){
            adjacency.add(new ArrayList<>());
        }

        //Create an adjacency matrix
        for(int[] pre: prerequisites){
            int course = pre[0];
            int prereq = pre[1];

            adjacency.get(prereq).add(course);
        }

        int[] indegree = new int[numCourses];

        //Find All indegrees
        for(int i = 0; i < numCourses; i++){
            for(int j: adjacency.get(i)){
                indegree[j]++;
            }
        }

        //Add all 0 indegrees into a queue
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                que.add(i);
            }
        }


        //While queue not empty iterate over it 
        int count = 0;
        int i = 0;
        while(!que.isEmpty()){
            int num = que.peek();
            que.remove();
            count++;

            for(int k: adjacency.get(num)){
                indegree[k]--;
                if(indegree[k] == 0) que.add(k);
            }
        }

        if(count == numCourses) return true;

        return false;
    }
}