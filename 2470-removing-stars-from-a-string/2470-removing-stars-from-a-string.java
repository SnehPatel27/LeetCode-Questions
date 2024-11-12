class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        for(char c: s.toCharArray()){
            if(!st.isEmpty() && c == '*'){
                st.pop();
            } else {
                st.push(c);
            }
        }

        if(st.isEmpty()) return "";

        while(!st.isEmpty()){
            res.append(st.peek());
            st.pop();
        }

        return res.reverse().toString();
    }
}