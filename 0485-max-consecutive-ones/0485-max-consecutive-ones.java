class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxlen = 0;
        int k = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                k++;
            }
            else{
                maxlen = Math.max(maxlen, k);
                k=0;
            }
        }

        return Math.max(k, maxlen);
    }
}