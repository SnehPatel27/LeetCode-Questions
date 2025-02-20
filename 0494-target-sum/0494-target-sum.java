class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for(int i = 0; i < nums.length; i++){
            totalSum += nums[i];
        }

        if(totalSum - target < 0 || ((totalSum - target) % 2) != 0) return 0;

        return countTotalWays(nums, ((totalSum - target) / 2), nums.length - 1);
    }

    public int countTotalWays(int[] nums, int target, int index){
        if(index == 0){
            if(target == 0 && nums[index] == 0) return 2;
            if(target == 0 || nums[index] == target) return 1;
            return 0;
        }

        int notTake = countTotalWays(nums, target, index - 1);
        int take = 0;
        if(nums[index] <= target){
            take = countTotalWays(nums, target - nums[index], index - 1);
        }

        return take + notTake;
    
    }
}