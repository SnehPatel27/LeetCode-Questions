class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;

        int low = 0;
        int high = 0;

        for(int i = 0; i < n; i++){
            low = Math.max(low, weights[i]);
            high += weights[i];
        }

        while(low < high){
            int mid = low + (high - low) / 2;
            if(isPossible(mid, weights, days)){
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public boolean isPossible(int capacity, int[] weights, int days){
        int totalWeight = 0;
        int daysNeeded = 1;

        for(int weight: weights){
            totalWeight += weight;
            if(totalWeight > capacity){
                daysNeeded++;
                totalWeight = weight;
            }
        }
        
        return daysNeeded <= days;
    }  
}