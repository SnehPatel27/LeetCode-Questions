class Solution {
    public int findPeakElement(int[] nums) {
        
        if(nums.length == 1) return 0;
        
        int low = 1;
        int high = nums.length - 2;

        if(nums[0] > nums[1]) return 0;
        if(nums[high + 1] > nums[high]) return high + 1;

        while(low <= high){
            int mid = (low + high) / 2;

            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;
            
            else if(nums[mid] > nums[mid - 1])
                low = mid + 1;

            else high = mid - 1;
        }

        return -1;
    }
}