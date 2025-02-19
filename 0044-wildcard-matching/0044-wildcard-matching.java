class Solution {
    public boolean isMatch(String s, String p) {
        
        int i = s.length();
        int j = p.length();

        int[][] dp = new int[i][j];

        for(int row[]: dp){
            Arrays.fill(row, -1);
        }

        return checkMatching(i - 1, j - 1, s, p, dp);
    }

    public boolean checkMatching(int i, int j, String s, String p, int[][] dp){

        if(i < 0 && j < 0) return true;
        if(j < 0 && i >= 0) return false;
        if(i < 0 && j >= 0){
            for(int x = 0; x <= j; x++){
                if(p.charAt(x) != '*')
                    return false;
            }
            return true;
        }

        if(dp[i][j] != -1) return dp[i][j] == 1;

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
            dp[i][j] = checkMatching(i - 1, j - 1, s, p, dp) ? 1 : 0;
        else if(p.charAt(j) == '*')
            dp[i][j] = (checkMatching(i, j - 1, s, p, dp) || checkMatching(i - 1, j, s, p, dp)) ? 1 : 0;
        else 
            dp[i][j] = 0;
            
        return dp[i][j] == 1;
    }
}