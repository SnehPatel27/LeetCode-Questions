class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {

        int[] output = new int[queries.length];
        int[] prefix = new int[words.length];

        for(int i = 0; i < words.length; i++){
            String str = words[i];

            if(checkIfVowel(str.charAt(0)) && checkIfVowel(str.charAt(str.length() - 1))){
                prefix[i] = (i > 0 ? prefix[i - 1] : 0) + 1;
            } else {
                prefix[i] = (i > 0 ? prefix[i - 1] : 0);
            }

        }   

        for(int i = 0; i < queries.length; i++){
            int left = queries[i][0];
            int right = queries[i][1];

            if(left == 0){
                output[i] = prefix[right];
            } else {
                output[i] = prefix[right] - prefix[left - 1];
            }
        }

        return output;
    }

    public boolean checkIfVowel(char c){
        
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}