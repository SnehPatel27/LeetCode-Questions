//This is the recursion with memoization solution
class Solution1 {
    public boolean isInterleave(String s1, String s2, String s3) {

        if(s1.length() + s2.length() != s3.length()) return false;

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for(int[] i: dp){
            Arrays.fill(i, -1);
        }

        if(checkIfInterleave(s1, s2, s3, 0, 0, dp) == 1){
            return true;
        } 
        return false;
    }

    public int checkIfInterleave(String s1, String s2, String s3, int index1, int index2, int[][] dp){
    
        if(index1 == s1.length() && index2 == s2.length()){
            return 1;
        }

        if (dp[index1][index2] != -1) return dp[index1][index2];

        int firstString = 0, secondString = 0;

        if(index1 < s1.length() && s1.charAt(index1) == s3.charAt(index1 + index2)){
            firstString = checkIfInterleave(s1, s2, s3, index1 + 1, index2, dp);
        }

        if(index2 < s2.length() && s2.charAt(index2) == s3.charAt(index1 + index2)){
            secondString = checkIfInterleave(s1, s2, s3, index1, index2 + 1, dp);
        }

        return dp[index1][index2] = Math.max(firstString, secondString);
    }
}

//This is the DP solution. 
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        if(s1.length() + s2.length() != s3.length()) return false;

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        //Index1 - 0 - s1.length()
        //Index2 - 0 - s2.length()

        int s1Len = s1.length();
        int s2Len = s2.length();

        dp[s1.length()][s2.length()] = true;

        for (int i = s1Len - 1; i >= 0; i--) {
            if (s1.charAt(i) == s3.charAt(i + s2Len) && dp[i + 1][s2Len]) {
                dp[i][s2Len] = true;
            }
        }

        for (int j = s2Len - 1; j >= 0; j--) {
            if (s2.charAt(j) == s3.charAt(s1Len + j) && dp[s1Len][j + 1]) {
                dp[s1Len][j] = true;
            }
        }

        for(int i = s1Len - 1; i >= 0; i--){
            for(int j = s2Len - 1; j >= 0; j--){

                boolean firstString = false, secondString = false;

                if(i < s1Len && s1.charAt(i) == s3.charAt(i + j)){
                    firstString = dp[i + 1][j];
                }

                if(j < s2Len && s2.charAt(j) == s3.charAt(i + j)){
                    secondString = dp[i][j + 1];
                }

                dp[i][j] = firstString || secondString;
            }
        }

        return dp[0][0];
    }
}