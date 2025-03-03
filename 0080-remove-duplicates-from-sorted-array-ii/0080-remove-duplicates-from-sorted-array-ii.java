class Solution {
    //This is the editorial first solution. Provide explanation for that.
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int i = 1;//Used for the current index in the array

        for(int j = 1; j < nums.length; j++){
            if(nums[j] == nums[j - 1]){
                count++;
            } else {
                count = 1;
            }

            if(count <= 2){
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }
}