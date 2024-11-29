class Solution {

    public long findBound(int[] nums, int low, int high, int target){

        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] >= target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        
        long count = 0;
        int n = nums.length;

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){

            long lowerBound = findBound(nums, i + 1, n - 1, lower - nums[i]);
            long upperBound = findBound(nums, i + 1, n - 1, upper - nums[i] + 1);

            count += upperBound - lowerBound;
        }
        return count;   
    }
}