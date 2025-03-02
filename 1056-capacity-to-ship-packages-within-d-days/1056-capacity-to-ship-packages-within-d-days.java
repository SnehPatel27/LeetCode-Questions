class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int low = Integer.MIN_VALUE;
        int high = 0;
        int day = 0;

        for(int i = 0; i < n; i++){
            low = Math.max(low, weights[i]);
            high += weights[i];
        }

        while(low <= high){
            int mid = (high + low) / 2;
            System.out.println("The mid days curently is " +mid);
            if(isPossible(mid, weights, days)){
                day = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return day;
    }

    public boolean isPossible(int currentDay, int[] weights, int days){
        int left = 0;
        int right = 0;
        int total = 0;
        int calculatedDays = 0;
        while(right < weights.length){
            total += weights[right];
            if(total > currentDay){
                calculatedDays++;
                total = weights[right];
                left = right;
            }
            right++;
        }
        calculatedDays++;
        System.out.println(calculatedDays+ " this is what it is");
        return calculatedDays <= days;
    }  
}