class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n];

        k = k % n;

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