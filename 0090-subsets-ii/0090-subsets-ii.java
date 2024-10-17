class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        findsubset(nums, result, subset, 0);
        
        return result;
    }

    public void findsubset(int[] nums, List<List<Integer>> result, List<Integer> subset, int index){
        if(index == nums.length){
            if(!result.contains(subset)){
                result.add(new ArrayList<>(subset));
            }
            return;
        }

        subset.add(nums[index]);
        findsubset(nums, result, subset, index + 1);
        subset.remove(subset.size() - 1);
        findsubset(nums, result, subset, index + 1);
    }
}