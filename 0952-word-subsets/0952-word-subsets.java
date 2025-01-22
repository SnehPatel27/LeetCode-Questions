class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        int maxFreq[] = new int[26];
        for(String s: words2){
            int freq[] = count(s);
            for(int i = 0; i < 26; i++){
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }

        List<String> result = new ArrayList<>();
        for(String s: words1){
            int[] a = count(s);
            if(isUniversal(a, maxFreq)){
                result.add(s);
            }
        }

        return result;
    }

    public boolean isUniversal(int[] freq, int[] maxFreq){
        for(int i = 0; i < 26; i++){
            if(freq[i] < maxFreq[i]){
                return false;
            }
        }

        return true;
    }

    public int[] count(String s){
        int[] arr = new int[26];
        for(char c: s.toCharArray()){
            arr[c - 'a']++; 
        }
        return arr;
    }
}