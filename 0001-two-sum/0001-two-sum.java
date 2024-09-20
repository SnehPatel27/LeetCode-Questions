class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> result = new HashMap<>();
        int arr[] = new int[2];

        for(int i=0; i<nums.length; i++){
            if(result.containsKey(target - nums[i])){
                arr[0] = result.get(target-nums[i]);
                arr[1] = i;

                return arr;
            }else{
                result.put(nums[i], i);
            }
        }

        return arr;
    }
}