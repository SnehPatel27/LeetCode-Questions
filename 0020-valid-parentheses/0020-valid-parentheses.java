class Solution {

    public boolean isValid(String s) {
        HashMap<Character, Character> brackets = new HashMap<>(){{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(brackets.containsValue(c)){
                st.push(c);
            } else if(!st.isEmpty() && st.peek() == brackets.get(c)){
                st.pop();
            } else return false;
        }

        return st.isEmpty();

    }

    public boolean isValidP(String s) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(st.isEmpty() || st.peek() != '('){
                    return false;
                }else{
                    st.pop();
                }
            }
            else if(s.charAt(i) == '}'){
                if(st.isEmpty() || st.peek() != '{'){
                    return false;
                }else{
                    st.pop();
                }
            }
            else if(s.charAt(i) == ']'){
                if(st.isEmpty() || st.peek() != '['){
                    return false;
                }else{
                    st.pop();
                }
            }
            else{
                st.push(s.charAt(i));
            }
        }
        if(!st.isEmpty()){
            return false;
        }
        return true;
    }
}