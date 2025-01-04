class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> result = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxlen = 0;
        int length = 0;
        int n = s.length();
        while(right < n){
            if(result.containsKey(s.charAt(right))){
                // if(result.get(s.charAt(right)) >= left){
                //     left = result.get(s.charAt(right)) + 1;
                // }

                left = Math.max(result.get(s.charAt(right)) + 1, left);
            }
            length = right - left + 1;
            maxlen = Math.max(length, maxlen);
            result.put(s.charAt(right), right);  
            right++;
        }

        return maxlen;
    }
}