class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;
            
            if(nums[mid] == target)
                return true;
            //For cases like [3,2,1,3,3,3,3]. In this case mid low and high all are same.
            //so sorted half is unknown so we would just trim down the search space.
            else if(nums[mid] == nums[low] && nums[low] == nums[high]){
                low++;
                high--;
                continue;
            }

            else if(nums[low] <= nums[mid]){
                if(target >= nums[low] && target <= nums[mid]){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            else if(nums[mid] <= nums[high]){
                if(target >= nums[mid] && target <= nums[high]){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }
}