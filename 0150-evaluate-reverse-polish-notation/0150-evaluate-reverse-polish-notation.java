class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int result = 0;

        for(int i = 0; i < tokens.length; i++){
            String currentCharacter = tokens[i];

            switch(currentCharacter){
                case "+":
                    result = st.pop() + st.pop();
                    st.push(result);
                    break;
                case "-":
                    result = - st.pop() + st.pop();
                    st.push(result);
                    break;
                case "*":
                    result = st.pop() * st.pop();
                    st.push(result);
                    break;
                case "/":
                    int second = st.pop();
                    int first = st.pop();
                    st.push(first / second);
                    break;
                default:
                    st.push(Integer.parseInt(currentCharacter));
            }
        }

        return st.peek();
    }
}