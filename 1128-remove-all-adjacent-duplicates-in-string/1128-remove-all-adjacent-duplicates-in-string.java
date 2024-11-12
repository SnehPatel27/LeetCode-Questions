class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!st.isEmpty() && st.peek() == c){
                st.pop();
            } else {
                st.push(c);
            }
        }

        while(!st.isEmpty()){
            result.append(st.peek());
            st.pop();
        }
        
        return result.reverse().toString();
    }
}