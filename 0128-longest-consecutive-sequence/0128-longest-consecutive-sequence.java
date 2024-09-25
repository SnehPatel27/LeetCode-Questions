class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int lastsmallest = Integer.MIN_VALUE;
        int count = 0;
        int result = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == lastsmallest + 1 || nums[i] == lastsmallest){
                if(nums[i] == lastsmallest + 1){
                    count++;
                    lastsmallest = nums[i];
                }else{
                    continue;
                }
            }else{
                count = 1;
                lastsmallest = nums[i];
            }
            result = Math.max(count, result);
        }
        return result;
    }
}