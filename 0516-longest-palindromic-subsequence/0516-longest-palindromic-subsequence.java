class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        String str = "";
        String sReverse = "";
        for(int i = n - 1; i >=0; i--){
            sReverse += s.charAt(i);
        }
        System.out.println(sReverse);
        System.out.println(s);
        return computeLCS(n - 1, n - 1, s, sReverse, str);
    }

    public int computeLCS(int index1, int index2, String s, String sReverse, String str){
        
        int i = 0;
        int j = 0;
        int len1 = s.length();
        int len2 = len1;
        int dp[][] = new int[len1 + 1][len2 + 1];

        for(i = 0; i <= len1; i++) dp[i][0] = 0;
        for(i = 0; i <= len2; i++) dp[0][i] = 0;

        for(i = 1; i <= len1; i++){
            for(j = 1; j <= len2; j++){
                if(s.charAt(i - 1) == sReverse.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[len1][len2];
    }
}