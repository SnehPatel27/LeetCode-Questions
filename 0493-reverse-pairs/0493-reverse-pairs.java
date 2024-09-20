class Solution {

    int count = 0;

    public int reversePairs(int[] nums) {
        int n = nums.length;

        mergesort(nums, 0, n-1);

        for(int i = 0; i<nums.length;i++){
            System.out.println(nums[i]);
        }

        return count;
    }

    public void mergesort(int[] nums, int low, int high){
        if(low == high){
            return;
        }

        int mid = (low + high) / 2;

        mergesort(nums, low, mid);
        mergesort(nums, mid + 1, high);
        reversePairsCount(nums, low, mid, high);
        merge(nums, low, mid, high);
    }

    public void reversePairsCount(int[] nums, int low, int mid, int high){
        int leftpointer = low;
        int rightpointer = mid + 1;

        for(int i = low; i <= mid; i++){
            while((rightpointer <= high) && ((long)nums[i] > 2 * (long)nums[rightpointer])){
                rightpointer++;
            }

            count = count + (rightpointer - (mid + 1));
        }
    }

    public void merge(int[] nums, int low, int mid, int high){
        int leftpointer = low;
        int rightpointer = mid + 1;
        int k = 0;

        int[] temp = new int[high - low + 1];

        while(leftpointer <= mid && rightpointer <= high){
            if(nums[leftpointer] <= nums[rightpointer]){
                temp[k] = nums[leftpointer];
                k++;
                leftpointer++;
            }else{
                temp[k] = nums[rightpointer];
                k++;
                rightpointer++;
            }
        }

        while(leftpointer <= mid){
            temp[k] = nums[leftpointer];
            k++;
            leftpointer++;
        }

        while(rightpointer <= high){
            temp[k] = nums[rightpointer];
            k++;
            rightpointer++;
        }

        for(int i = low; i <= high; i++){
            nums[i] = temp[i - low];
        }
    }
}