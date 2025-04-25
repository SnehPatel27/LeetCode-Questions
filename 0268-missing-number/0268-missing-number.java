class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        boolean[] arr = new boolean[n + 1];

        for(int i = 0; i < n; i++){
            arr[nums[i]] = true;
        }

        for(int i = 0; i <= n; i++){
            if(arr[i] == false){
                return i;
            }
        }

        return -1;
    }
}