class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int p=0;
        int answer = 0;
        int leftpointer = 0;
        for(int i=0;i<s.length();i++){
            char currentChar = s.charAt(i);
            if(map.containsKey(currentChar) && map.get(currentChar) >= leftpointer){
                leftpointer = map.get(currentChar) + 1;
            }
            map.put(currentChar, i);
            answer = Math.max(answer, i - leftpointer + 1);    
        }
        return Math.max(answer, p);
    }
}