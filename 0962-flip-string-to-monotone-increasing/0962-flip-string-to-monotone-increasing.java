class Solution {
    //We want two substrings - 1 containing all 0s and other containing all 1s.
    //first start with a single right window which should be all 1s
    //Then count the number of 0s.
    //Then iterate over the entire string one by one and start placing one char from the right window to the left.
    //if the char is 0. res = res - 1;
    //if char is 1 res = res + 1;
    //calculate the min at each iteration
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