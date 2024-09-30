class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> result = new HashMap<>();
        int length = 0;
        int maxlength = 0;
        int startIndex = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(result.containsKey(c)){
                startIndex = Math.max(result.get(c) + 1, startIndex);
            }
            maxlength = Math.max(i - startIndex + 1, maxlength);
            result.put(c, i);
        }
        return Math.max(length, maxlength);
    }
}

// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         Map<Character, Integer> map = new HashMap<>();
//         int p=0;
//         int answer = 0;
//         int leftpointer = 0;
//         for(int i=0;i<s.length();i++){
//             char currentChar = s.charAt(i);
//             if(map.containsKey(currentChar) && map.get(currentChar) >= leftpointer){
//                 leftpointer = map.get(currentChar) + 1;
//             }
//             map.put(currentChar, i);
//             answer = Math.max(answer, i - leftpointer + 1);    
//         }
//         return Math.max(answer, p);
//     }
// }