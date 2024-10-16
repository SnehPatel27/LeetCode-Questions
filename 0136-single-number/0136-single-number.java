class Solution {
    public int singleNumber(int[] nums) {
        int xor_number = 0;

        for(int i = 0; i < nums.length; i++){
            xor_number = xor_number ^ nums[i];
        }

        return xor_number;
    }
}