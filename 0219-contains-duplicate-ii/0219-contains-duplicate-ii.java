class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> numCount = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(numCount.containsKey(nums[i])){
                if(Math.abs(i - numCount.get(nums[i])) <= k)
                    return true;
            }
            numCount.put(nums[i], i);
        }

        return false;
    }
}