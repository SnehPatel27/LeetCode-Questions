class MinStack {
    
    Stack<Long> st = new Stack<>();
    long min = Long.MAX_VALUE;    

    public MinStack() {
    }
    
    public void push(int value) {
        Long val = Long.valueOf(value);
        if(st.isEmpty()){
            st.push(val);
            min = val;
        } else {
            if(val < min){
                st.push(2 * val - min);
                min = val;
            } else {
                st.push(val);
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;

        Long val = st.pop();
        
        if(val < min){
            min = 2 * min - val;
        }
    }
    
    public int top() {
        Long val = st.peek();
        if(val < min){
            return (int)min;
        } else {
            return val.intValue();
        }
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */