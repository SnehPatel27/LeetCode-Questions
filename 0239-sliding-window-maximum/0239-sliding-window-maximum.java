class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0)
            return new int[0];

        Deque<Integer> dq = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        
        for(int i = 0; i < nums.length; i++){
            if(!dq.isEmpty() && dq.peekFirst() < i - k + 1){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]){
                dq.pollLast();
            }

            dq.offerLast(i);

            if(i >= k - 1){
               res[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return res;
    }
}