class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        HashMap<Integer, Integer> totalTime = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        int lastTime = 0;

        for(String log: logs){
            String[] paths = log.split(":");
            int functionId = Integer.parseInt(paths[0]);
            String status = paths[1];
            int timeStamp = Integer.parseInt(paths[2]);

            if(status.equals("start")){
                if(!st.isEmpty()){
                    totalTime.put(st.peek(), totalTime.getOrDefault(st.peek(), 0) + timeStamp - lastTime);
                }
                st.push(functionId);
            } else {
                int completedFunc = st.pop();
                totalTime.put(completedFunc, totalTime.getOrDefault(completedFunc, 0) + timeStamp - lastTime + 1);
            }

            lastTime = (status.equals("start")) ? timeStamp : timeStamp + 1;
        }

        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = totalTime.get(i);
        }

        return arr;
    }
}