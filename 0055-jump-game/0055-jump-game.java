class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxIndex = 0;

        for(int i = 0; i < n; i++){
            if(i > maxIndex){
                return false;
            }else if(maxIndex >= n){
                return true;
            }

            maxIndex = Math.max(maxIndex, nums[i] + i);
        }

        return true;
    }
}