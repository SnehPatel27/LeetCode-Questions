class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int result = 0;
        for(int i = 0; i < n; i++){
            int[] freq = new int[26];
            int maxFreq = 0;
            for(int j = i; j < n; j++){
                char c = s.charAt(j);
                freq[c - 'a']++;
                maxFreq = Math.max(maxFreq, freq[c - 'a']);

                int minFreq = Integer.MAX_VALUE;
                for(int k = 0; k < 26; k++){
                    if(freq[k] != 0){
                        minFreq = Math.min(freq[k], minFreq);
                    }
                }
                result += maxFreq - minFreq;
            }
        }
        return result;
    }
}