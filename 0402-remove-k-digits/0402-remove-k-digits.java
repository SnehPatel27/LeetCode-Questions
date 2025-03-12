class Solution {
    //This is my solution
    public String removeKdigits1(String num, int k) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < num.length(); i++){
            char c = num.charAt(i);
            while(!st.isEmpty() && k > 0 && st.peek() > c){
                st.pop();
                k--;
            }
            st.push(c);
        }
        
        while(k > 0 && !st.isEmpty()){
            st.pop();
            k--;
        }

        if(st.size() == 0) return "0";
        
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            res.append(st.pop());
        }

        res.reverse();

        while(res.length() > 1 && res.charAt(0) == '0'){
            res.deleteCharAt(0);
        }
        
        return res.toString();
    }

    //This is the editorial solution
    /*
    Java's Stack Class:
    The built-in Stack is based on Vector and is synchronized, meaning every operation is thread-safe. 
    In a single-threaded scenario, this extra synchronization can add unnecessary overhead.
    */
    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<Character>();
        
        for(char digit : num.toCharArray()) {
        while(stack.size() > 0 && k > 0 && stack.peekLast() > digit) {
            stack.removeLast();
            k -= 1;
        }
        stack.addLast(digit);
        }
            
        /* remove the remaining digits from the tail. */
        for(int i=0; i<k; ++i) {
        stack.removeLast();
        }
            
        // build the final string, while removing the leading zeros.
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        for(char digit: stack) {
        if(leadingZero && digit == '0') continue;
        leadingZero = false;
        ret.append(digit);
        }
        
        /* return the final string  */
        if (ret.length() == 0) return "0";
        return ret.toString();
    }
}