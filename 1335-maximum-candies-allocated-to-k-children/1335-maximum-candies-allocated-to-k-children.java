class Solution {
    public int maximumCandies(int[] candies, long k) {        
        
        long total = 0;
        long ans = 0;
        for(int i: candies){
            total += i;
        }
        
        long low = 1;
        long high = total / k;
        
        if(high < low) return 0;
        
        while(low <= high){
            long mid = (high + low ) / 2;
            long totalChildren = maximumCandiesHelper(candies, mid);
            if(totalChildren >= k){
                ans = Math.max(ans, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return (int)ans;
    }

    public long maximumCandiesHelper(int[] candies, long k){
        
        long totalChildren = 0;
        
        for(int i: candies){
            totalChildren += i/k; 
        }
        return totalChildren;
    }
}