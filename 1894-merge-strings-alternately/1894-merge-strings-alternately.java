class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int k = 0;
        StringBuilder res = new StringBuilder();

        while(k < len1 && k < len2){
            res.append(word1.charAt(k));
            res.append(word2.charAt(k));
            k++;
        }

        while(k < len1){
            res.append(word1.charAt(k));
            k++;
        }

        while(k < len2){
            res.append(word2.charAt(k));
            k++;
        }

        return res.toString();
    }
}