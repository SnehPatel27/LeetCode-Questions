class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int arr[] = new int[n];
        Stack<Integer> st = new Stack<>();
        int lastTime = 0;

        for(String log: logs){
            String[] paths = log.split(":");
            int functionId = Integer.parseInt(paths[0]);
            String status = paths[1];
            int timeStamp = Integer.parseInt(paths[2]);

            if(status.equals("start")){
                if(!st.isEmpty()){
                    arr[st.peek()] += timeStamp - lastTime;
                }
                st.push(functionId);
                lastTime = timeStamp;
            } else {
                arr[st.pop()] += timeStamp - lastTime + 1;
                lastTime = timeStamp + 1;
            }
        }

        return arr;
    }
}