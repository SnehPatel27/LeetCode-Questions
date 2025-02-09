class Solution {
    public int minSteps(String s, String t) {
        int[] freq = new int[26];
        int ans = 0;

        for(int i = 0; i < s.length(); i++){
            freq[t.charAt(i) - 'a']++;
            freq[s.charAt(i) - 'a']--;
        }

        for(int i = 0; i < 26; i++){
            ans += Math.max(0, freq[i]);
        }

        return ans;
    }
}