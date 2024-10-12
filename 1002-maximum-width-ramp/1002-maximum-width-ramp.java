class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> result = new Stack<>();
        int maxcount = 0;

        for(int i = 0; i < nums.length; i++){
            if(result.isEmpty() || nums[i] < nums[result.peek()]){
                result.push(i);
            }
        }

        for(int j = nums.length - 1; j >= 0; j--){
            while(!result.isEmpty() && nums[j] >= nums[result.peek()]){
                maxcount = Math.max(maxcount, j - result.peek());
                result.pop();
            }
        }

        return maxcount;
    }
}