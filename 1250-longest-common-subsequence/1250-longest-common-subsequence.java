class Solution1 {
    public int longestCommonSubsequences(String text1, String text2) {
        int s1 = text1.length();
        int s2 = text2.length();
        int[][] dp = new int[s1 + 1][s2 + 1];
        for(int i = 0; i <= s1; i++) dp[i][0] = 0;
        for(int i = 0; i <= s2; i++) dp[0][i] = 0;

        for(int i = 1; i <= s1; i++){
            for(int j = 1; j <= s2; j++){
                
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[s1][s2];
    }
}

//This is the recursive solution

public class Solution2{
    public int longestCommonSubsequence(String text1, String text2) {
        
        return checkSubsequence(text1.length() - 1, text2.length() - 1, text1, text2);
    }

    public int checkSubsequence(int index1, int index2, String text1, String text2){

        if(index1 < 0 || index2 < 0) return 0;
        
        if(text1.charAt(index1) == text2.charAt(index2)){
            return 1 + checkSubsequence(index1 - 1, index2 - 1, text1, text2);
        }

        return Math.max(checkSubsequence(index1 - 1, index2, text1, text2), checkSubsequence(index1, index2 - 1, text1, text2)); 
    }
}


//This is the memoization solution

class Solution{
    public int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[text1.length()][text2.length()];

        for(int i[]: dp){
            Arrays.fill(i, -1);
        }
        
        return checkSubsequence(text1.length() - 1, text2.length() - 1, text1, text2, dp);
    }

    public int checkSubsequence(int index1, int index2, String text1, String text2, int[][] dp){

        if(index1 < 0 || index2 < 0) return 0;

        if(dp[index1][index2] != -1) return dp[index1][index2];
        
        if(text1.charAt(index1) == text2.charAt(index2)){
            return dp[index1][index2] = 1 + checkSubsequence(index1 - 1, index2 - 1, text1, text2, dp);
        }

        return dp[index1][index2] = Math.max(checkSubsequence(index1 - 1, index2, text1, text2, dp), checkSubsequence(index1, index2 - 1, text1, text2, dp)); 
    }
}


//This is the dp solution