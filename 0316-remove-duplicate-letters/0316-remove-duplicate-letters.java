class Solution {
    public String removeDuplicateLetters(String s) {
        HashSet<Character> seen = new HashSet<>();
        Stack<Character> st = new Stack<>();
        HashMap<Character, Integer> freq = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            freq.put(s.charAt(i), i);
        }
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(!seen.contains(c)){

                while(!st.isEmpty() && c < st.peek() && freq.get(st.peek()) > i){
                    seen.remove(st.peek());
                    st.pop();
                }

                st.push(c);
                seen.add(c);
            }
        }

        StringBuilder res = new StringBuilder(st.size());
        for(Character c: st){
            res.append(c);
        }

        return res.toString();
    }
}