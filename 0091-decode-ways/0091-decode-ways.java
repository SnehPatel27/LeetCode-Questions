class Solution {
    public int numDecodings(String s) {

        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        return helper(s, 0, dp);
    }

    public int helper(String s, int index, int[] dp){

        if(index == s.length()){
            return 1;
        }

        if(s.charAt(index) == '0') return 0;

        if(dp[index] != -1) return dp[index];

        int ans = 0;

        ans = helper(s, index + 1, dp);
        if(index + 1 < s.length() && Integer.parseInt(s.substring(index, index + 2)) <= 26){
            ans += helper(s, index + 2, dp);
        }

        return dp[index] = ans;
    }
}