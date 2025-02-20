class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] freq = new int[26];

        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }

        int frequency = -1;
        for(int i = 0; i < 26; i++){
            if(frequency == -1 && freq[i] > 0){
                frequency = freq[i];
            }
            else if(freq[i] > 0 && frequency != freq[i]){
                return false;
            }
        }

        return true;
    }
}