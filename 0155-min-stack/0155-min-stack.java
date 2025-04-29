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

//You can also use Two Stack Solution
class MinStackk {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public MinStackk() {}

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

//You can optimize the two stack solution
//So the issue with the above solution was there would be repeated values stored in the stack. For instance if 6 comes 5 times then in the min stack there would be 5 sixes stored and upon popping out there would be multiple pop operations too. So in the min stack instead of just storing the min value on the top you can store the frequency of the min number too. Upon popping you check if the number that i am popping as same as the top of the minstack and if yes then you decrement the count of the frequency by 1 and only pop if the frequency becomes 0. 
class MinStackkk {
    private Stack<Integer> stack = new Stack<>();
    private Stack<int[]> minStack = new Stack<>();

    public MinStackkk() {}

    public void push(int x) {
        // We always put the number onto the main stack.
        stack.push(x);

        // If the min stack is empty, or this number is smaller than
        // the top of the min stack, put it on with a count of 1.
        if (minStack.isEmpty() || x < minStack.peek()[0]) {
            minStack.push(new int[] { x, 1 });
        }
        // Else if this number is equal to what's currently at the top
        // of the min stack, then increment the count at the top by 1.
        else if (x == minStack.peek()[0]) {
            minStack.peek()[1]++;
        }
    }

    public void pop() {
        // If the top of min stack is the same as the top of stack
        // then we need to decrement the count at the top by 1.
        if (stack.peek().equals(minStack.peek()[0])) {
            minStack.peek()[1]--;
        }

        // If the count at the top of min stack is now 0, then remove
        // that value as we're done with it.
        if (minStack.peek()[1] == 0) {
            minStack.pop();
        }

        // And like before, pop the top of the main stack.
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek()[0];
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