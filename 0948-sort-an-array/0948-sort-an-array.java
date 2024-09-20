class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        mergesort(nums, 0, n-1);

        return nums;
    }

    public void mergesort(int[] nums, int low, int high){
        if(low == high){
            return;
        }

        int mid = (low + high)/2;

        mergesort(nums, low, mid);
        mergesort(nums, mid+1, high);

        merge(nums, low, mid, high);
    }

    public void merge(int[] nums, int low, int mid, int high){

        int[] temp = new int[high - low + 1];

        int leftpointer = low;
        int rightpointer = mid+1;

        int k = 0; 

        while(leftpointer <= mid && rightpointer <= high){
            if(nums[leftpointer] <= nums[rightpointer]){
                temp[k] = nums[leftpointer];
                leftpointer++;
                k++;
            }else{
                temp[k] = nums[rightpointer];
                rightpointer++;
                k++;
            }
        }

        while(leftpointer <= mid){
            temp[k] = nums[leftpointer];
            leftpointer++;
            k++;
        }

        while(rightpointer <= high){
            temp[k] = nums[rightpointer];
            rightpointer++;
            k++;
        }

        for(int i = low; i <= high; i++){
            nums[i] = temp[i - low];
        }
    }
}