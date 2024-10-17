class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> inter = new ArrayList<>();
        findsubsets(nums, 0, inter, result); 
        return result;
    }

    public void findsubsets(int[] nums, int index, List<Integer> inter, List<List<Integer>> result){
        if(index == nums.length){
            result.add(new ArrayList<>(inter));
            return;
        }

        inter.add(nums[index]);
        findsubsets(nums, index+1, inter, result);
        inter.remove(inter.size() - 1);
        findsubsets(nums, index+1, inter, result);
    }
}