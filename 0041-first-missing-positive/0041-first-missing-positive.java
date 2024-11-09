class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean[] seen = new boolean[nums.length + 1];
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] > 0 && nums[i] <= n){
                seen[nums[i]] = true;
            }
        }

        for(int i = 1; i <= n; i++){
            if(!seen[i]){
                return i;
            }
        }

        return n + 1;
    }
}