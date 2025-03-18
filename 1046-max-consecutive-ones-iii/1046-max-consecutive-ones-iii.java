class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        int maxLength = 0;
        int flips = 0;
        while(right < n){
            int currentChar = nums[right];
            if(currentChar == 0){
                flips++;
            }
            while(flips > k){
                if(nums[left] == 0){
                    flips--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}