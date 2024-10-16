class Solution {
    public int maxSubArray(int[] nums) {
        int max = 0;
        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            max = max + nums[i];
            ans = Math.max(ans, max);
            if(max < 0){
                max = 0;
            }

        }
        return ans;
    }
}