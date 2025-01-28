class Solution {
    public int minFlipsMonoIncr(String s) {
        
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                res++;
            }
        }

        int ans = res;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                res--;
            } else {
                res++;
            }

            ans = Math.min(ans, res);
        }

        return ans;
    }
}