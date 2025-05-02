//This is the recursion with memoization solution
class Solution1 {
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

//This is the DP solution
class Solution {
    public int numDecodings(String s) {

        int n = s.length();
        int dp[] = new int[n + 1];

        dp[n] = 1;

        int ans = 0;
        for(int i = n - 1; i >= 0; i--){
            if(s.charAt(i) == '0') 
                dp[i] = 0;
            else{
                dp[i] = dp[i + 1];
                if(i + 1 < n && Integer.parseInt(s.substring(i, i + 2)) <= 26){
                    dp[i] += dp[i + 2];
                }
            }
        }

        return dp[0];   
    }
}

