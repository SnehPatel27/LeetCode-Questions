class Solution {
    public void nextPermutation(int[] nums) {
        int index = -1;
        int n = nums.length;
        int t;
        for(int i=n-2;i>=0;i--){
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }
        System.out.println(index);
        if(index == -1){
           reverse(0, n-1, nums);
            return;
        }
        else
        {
            for(int i=n-1;i>index;i--){
                if(nums[i] > nums[index]){
                    t = nums[index];
                    nums[index] = nums[i];
                    nums[i] = t;
                    break;
                }
            }
            reverse(index + 1, n-1, nums);
        }
    }

    public void reverse(int start, int end, int[] nums){
        while(start<end){
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}