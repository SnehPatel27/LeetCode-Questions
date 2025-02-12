class Solution {
    public String decodeString(String s) {
        
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ']'){
                List<Character> decodedString = new ArrayList<>();
                while(st.peek() != '['){
                    decodedString.add(st.pop());
                }
                st.pop();
                int base = 1;
                int k = 0;
                while(!st.isEmpty() && Character.isDigit(st.peek())){
                    k = k + ((st.pop() - '0') * base);
                    base = base * 10;
                }

                while(k > 0){
                    for(int j = decodedString.size() - 1; j >= 0; j--){
                        st.push(decodedString.get(j));
                    }
                    k--;
                }
            } else {
                st.push(s.charAt(i));
            }   
        }

        StringBuilder res = new StringBuilder();
        for(int i = st.size() - 1; i >= 0; i--){
            res.append(st.pop());
        }

        return res.reverse().toString();
    }
}