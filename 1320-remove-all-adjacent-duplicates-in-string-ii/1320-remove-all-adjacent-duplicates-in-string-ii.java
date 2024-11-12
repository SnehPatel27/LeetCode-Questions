class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!st.isEmpty() && st.peek()[0] == c){

                st.peek()[1] = st.peek()[1] + 1;    

                if(st.peek()[1] == k){
                    st.pop();
                }

            } else {
                st.push(new int[]{c, 1});
            }
        }

        StringBuilder result = new StringBuilder();

        while(!st.isEmpty()){
            result.append(String.valueOf((char)st.peek()[0]).repeat(st.peek()[1]));
            st.pop();
        }

        return result.reverse().toString();
    }
}