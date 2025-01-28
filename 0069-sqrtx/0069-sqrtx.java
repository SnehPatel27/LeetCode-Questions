class Solution {
    
    //This is the brute force solution 
    public int mySqrt(int x) {
        if(x == 1) return 1;
        int ans = 0;
        for(int i = 1; i < x; i++){
            if(i  <= x/i)
                ans = i;
            else
                break;
        }   
        return ans;
    }
}