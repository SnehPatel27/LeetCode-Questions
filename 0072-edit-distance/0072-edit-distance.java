class Solution {
    public int minDistance(String word1, String word2) {

        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] i: dp){
            Arrays.fill(i, -1);
        }
        return minDistanceHelper(word1, word2, 0, 0, dp);
    }

    public int minDistanceHelper(String word1, String word2, int index1, int index2, int[][] dp){

        //Base Condition
        if(index1 == word1.length()) return word2.length() - index2;

        if(index2 == word2.length()) return  word1.length() - index1;

        if(dp[index1][index2] != -1) return dp[index1][index2];

        int removeWord = 0, insertWord = 0, replaceWord = 0;
        
        if(word1.charAt(index1) == word2.charAt(index2)){
            return minDistanceHelper(word1, word2, index1 + 1, index2 + 1, dp);
        } else {
            //This is the case for removing the word
            removeWord = 1 + minDistanceHelper(word1, word2, index1 + 1, index2, dp);

            //This is the case for inserting the word
            insertWord = 1 + minDistanceHelper(word1, word2, index1, index2 + 1, dp);

            //This is the case for replacing the word  
            replaceWord = 1 + minDistanceHelper(word1, word2, index1 + 1, index2 + 1, dp);
        }

        return dp[index1][index2] = Math.min(removeWord, Math.min(insertWord, replaceWord));
    }
}