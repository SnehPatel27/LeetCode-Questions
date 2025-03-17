class Solution {
    public boolean judgeSquareSum(int c) {
        int low = 0;
            int high = (int)Math.sqrt(c);

            while(low <= high){
                long sum = (1L * low * low + 1L * high * high);
                if(sum == c){
                    return true;
                } else if(sum < c){
                    low++;
                } else high--;
            }

            return false; 
    }  
}