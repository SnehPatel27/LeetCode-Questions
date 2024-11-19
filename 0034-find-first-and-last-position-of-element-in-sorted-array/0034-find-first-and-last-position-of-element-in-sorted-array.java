class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int[] result = new int[2];

        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] > target)
                right = mid - 1;
            else if(nums[mid] < target)
                left = mid + 1;
            else{
                
                left = mid;
                right = mid;

                while(left > 0 && nums[left - 1] == nums[mid])
                    left--;

                while(right < nums.length - 1 && nums[right + 1] == nums[mid])
                    right++;

                result[0] = left;
                result[1] = right;

                return result;
            }
        }

        result[0] = -1;
        result[1] = -1;

        return result;
    }
}