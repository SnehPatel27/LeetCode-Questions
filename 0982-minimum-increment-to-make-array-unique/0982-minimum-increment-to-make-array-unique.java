class Solution {
    
    //Time limit execeeded solution 
    public int minIncrementForUniquee(int[] nums) {
        HashSet<Integer> res = new HashSet<>();
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            while(res.contains(nums[i])){
                nums[i]++;
                count++;
            }
            res.add(nums[i]);
        }
        return count;
    }

    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] >= nums[i]){
                res += 1 + nums[i - 1] - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }

        return res;
    }
}