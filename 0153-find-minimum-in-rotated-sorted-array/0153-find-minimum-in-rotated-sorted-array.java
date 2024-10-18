class Solution {
    public int findMin(int[] nums) {
        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        int min = Integer.MAX_VALUE;
        int mid;
        
        while(leftPointer <= rightPointer){
            mid = (leftPointer + rightPointer) / 2;
            if(nums[leftPointer] <= nums[mid]){
                min = Math.min(min, nums[leftPointer]);
                leftPointer = mid + 1;
            }else{
                min = Math.min(min, nums[mid]);
                rightPointer = mid - 1;
            }
        }

        return min;
    }
}