class Solution {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(0, n - 1, nums);
        reverse(0, k - 1, nums);
        reverse(k, n - 1, nums);
    }

    public void reverse(int start, int end, int[] nums){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate_Brute(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n];

        k = k % n;
        if(k == 0) return;

        int counter = 0;

        for(int i = n - k; i < n; i++){
            result[counter++] = nums[i];
        }

        for(int i = 0; i < n - k; i++){
            result[counter++] = nums[i];
        }

        for(int i = 0; i < n; i++){
            nums[i] = result[i];
        }
    }
}