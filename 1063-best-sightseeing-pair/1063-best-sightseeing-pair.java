class Solution {
    
    //Brute Force solution would be to iterate over all the possible pairs and compute the max.
    public int maxScoreSightseeingPair(int[] values) {
        
        int currentMax = values[0] - 1;
        int max = Integer.MIN_VALUE;

        //Keep the track of the maximum element on the left and keep on moving forward.
        //At every iteration the max is decremented by 1 because j - i increases by 1.

        for(int i = 1; i < values.length; i++){
            max = Math.max(max, values[i] + currentMax);
            currentMax = Math.max(currentMax - 1, values[i] - 1);
        }

        return max;
    }
}