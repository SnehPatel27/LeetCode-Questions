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

/*
1) Initialize an array result[n] to store exclusive times for each function.

    result[i] will eventually store the exclusive time of function i.

2) Use a stack to simulate the function call stack:

    The function on top of the stack is the one currently executing.

    When a function starts, we pause the one currently running (if any) and push the new one.

    When a function ends, we pop it and calculate how long it was running.

3) Track time using a variable lastTime:

    This helps us know how much time has passed between logs.

    For "start" logs, we use timestamp - lastTime

    For "end" logs, we use timestamp - lastTime + 1 (because end includes the full timestamp unit)

4) Process each log:

    Split the log into functionId, status, and timestamp.

    If status == "start":

        If a function is already running (stack.peek()), we update its time:
        result[stack.peek()] += timestamp - lastTime → We're pausing it now, so we account for the time it ran till now.

        Push the new function onto the stack.

        Update lastTime = timestamp.

    If status == "end":

        Pop the completed function from the stack.

        Add its running time:
        result[id] += timestamp - lastTime + 1 → The function ends at the end of this timestamp, so we include it.

        Update lastTime = timestamp + 1 → Because the next function resumes after this timestamp.

5) After processing all logs, return the result array.
*/