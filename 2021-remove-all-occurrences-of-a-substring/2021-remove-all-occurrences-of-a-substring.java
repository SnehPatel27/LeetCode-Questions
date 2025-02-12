class Solution {

    //This is the brute force solution
    public String removeOccurrences1(String s, String part) {
        
        while(s.contains(part)){
            int index = s.indexOf(part);
            s = s.substring(0, index) + s.substring(index + part.length());
        }

        return s;
    }

    //This is the optimal solution that uses stack
    public String removeOccurrences(String s, String part) {
        
        Stack<Character> st = new Stack<Character>();

        for(int i = 0; i < s.length(); i++){
            
            st.push(s.charAt(i));

            if(st.size() >= part.length() && checkIfCommon(st, part)){
                for(int j = 0; j < part.length(); j++){
                    st.pop();
                }
            }
        }

        StringBuilder res = new StringBuilder();
        for(char c: st){
            res.append(c);
        }

        return res.toString();
    }

    public boolean checkIfCommon(Stack<Character> st, String part){
        int len = part.length();

        Stack<Character> temp = new Stack<>();
        temp.addAll(st);

        for(int i = len - 1; i >= 0; i--){
            
            if(temp.peek() != part.charAt(i)) return false;

            temp.pop();
        }
        
        return true;
    }
}