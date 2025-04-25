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

/* 
In this approach, you first scan the array from right to left to find the first index i where nums[i] < nums[i+1] — this identifies the point where the array stops increasing and needs adjustment. If no such index exists (meaning the array is completely non-increasing), you simply reverse the entire array to get the lowest possible order (sorted ascending). Otherwise, once you find the index, you scan again from the right to find the first element greater than nums[i], swap them, and finally reverse the subarray from i+1 to the end to make it the next immediate larger permutation.

Time - O(n) to iterate and also to reverse
Space - O(1) 
*/