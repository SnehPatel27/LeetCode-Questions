class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adjacency = new ArrayList<>();

        //Initialize an array
        //The Size of the ArrayList would be equal to the number of courses.
        for(int i = 0; i < numCourses; i++){
            adjacency.add(new ArrayList<>());
        }

        //There would be an edge from preReq -> course. 
        //to .get(preReq).add(Course)
        //Create an adjacency matrix
        for(int[] pre: prerequisites){
            int course = pre[0];
            int prereq = pre[1];

            adjacency.get(prereq).add(course);
        }

        int[] indegree = new int[numCourses];

        //Find All indegrees
        //Iterate over the adjacency list and for each value increment its indegree
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
        //Remove first the one with indegree zero
        //For that course decrement the indegree for all the nodes that it points to. 
        //If the indegree for that node becomes 0 add that to the queue.
        //Keep a count variable to check the number of elements that I am adding to the final result list.
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

        //Check if the elements in the toposort are equal to the number of courses.
        if(count == numCourses) return true;

        return false;
    }
}