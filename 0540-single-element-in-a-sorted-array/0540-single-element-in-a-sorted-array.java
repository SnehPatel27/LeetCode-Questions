class Solution {
    public int singleNonDuplicate1(int[] nums) {
        
        int n = nums.length;
        int low = 1;
        int high = nums.length - 2;

        if(n == 1) return nums[0];

        if(nums[low] != nums[low - 1]) return nums[0];
        if(nums[high] != nums[high + 1]) return nums[n - 1];

        while(low <= high) {

            int mid = (low + high) / 2;

            if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
                return nums[mid];

            else if((mid % 2 == 0 && nums[mid] == nums[mid + 1]) || (mid % 2 == 1 && nums[mid] == nums[mid - 1]))
                low = mid + 1;
            
            else 
                high = mid - 1; 
        }

        return -1;
    }
    public int singleNonDuplicate(int[] nums) {
        int result = 0;
            for (int num : nums) {
                result ^= num;  // XOR each number with result
            }
        return result;
    }
}