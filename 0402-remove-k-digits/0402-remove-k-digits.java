class Solution {
    public String removeKdigits(String num, int k) {
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
}