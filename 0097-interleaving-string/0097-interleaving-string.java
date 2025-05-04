class Solution {
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