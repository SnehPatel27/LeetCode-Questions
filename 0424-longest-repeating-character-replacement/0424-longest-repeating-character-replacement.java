class Solution {
    public int characterReplacement(String s, int k) {
        int[] hashMap = new int[26];
        int left = 0;
        int right = 0;
        int maxFreq = 0;
        int maxlen = 0;
        int max = 0;
        int n = s.length();
        while(right < n){
            hashMap[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, hashMap[s.charAt(right) - 'A']);
            while((right - left + 1) - maxFreq > k){
                hashMap[s.charAt(left) - 'A']--;
                for(int i = 0; i < 26; i++){
                    maxFreq = Math.max(maxFreq, hashMap[i]);
                }
                left++;
            }

            if((right - left + 1) - maxFreq <= k){
                max = Math.max(max, right - left + 1);
            }
            right++;
        }

        return max;
    }
}