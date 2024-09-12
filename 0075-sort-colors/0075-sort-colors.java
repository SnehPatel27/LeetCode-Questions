class Solution {
    public void sortColors(int[] nums) {
        // int t;
        // for(int i=0;i< nums.length; i++){
        //     for(int j=0; j<nums.length-1; j++){
        //         if(nums[j] > nums[j+1]){
        //             t = nums[j];
        //             nums[j] = nums[j+1];
        //             nums[j+1] = t;
        //         }
        //     }
        // }

        int low = 0;
        int mid = 0;
        int high = nums.length-1;
        if(nums.length == 1){
            return;
        }
        while(mid<=high){
            if(nums[mid] == 2){
                swap(mid, high, nums);
                high--;

            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                swap(low, mid, nums);
                low++;
                mid++;
            }
        }
    }

    public void swap(int a, int b, int[] nums){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}