class Solution {
    public int minSteps(String s, String t) {
        int[] freq = new int[26];
        int ans = 0;

        //Count all the characters in t that are not present in s.
        //It means we are getting those characters that we need to remove.
        //number of characters to remove would be equal to number of chars to add
        for(int i = 0; i < s.length(); i++){
            freq[t.charAt(i) - 'a']++;
            freq[s.charAt(i) - 'a']--;
        }

        for(int i = 0; i < 26; i++){
            if(freq[i] < 0){
                ans += Math.abs(freq[i]);
            }

            
        }

        return ans;
    }
}