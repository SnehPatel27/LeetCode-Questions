/* Single Stack with Encoded Values:
Instead of storing the actual values in the stack, when a new value is pushed that is smaller than the current minimum, it pushes a special value:

encoded = 2 × newValue − min
This encoded value is smaller than the new value and lets you recover the previous minimum later.

Tracking Minimum Separately:
The variable min always stores the current minimum element in the stack.

How Push Works

Case 1: Stack is Empty
Simply push the value and update min with that value.

Case 2: Value is Greater Than or Equal to Current Min
Just push the value as-is.

Case 3: Value is Less Than Current Min
Before updating min, compute the encoded value:
encoded=2×newValue−min

Push this encoded value.
Update min to the new value.
Why does this work?
The encoded value is guaranteed to be less than the new value (and also less than the old min). It serves as a flag that tells us that at this point, the minimum changed.
*/

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