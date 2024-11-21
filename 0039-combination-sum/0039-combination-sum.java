class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        findCombinationSum(0, candidates, target, result, new ArrayList<>());

        return result;
    }

    public void findCombinationSum(int index, int[] candidates, int target, List<List<Integer>> result, List<Integer> temp){

        if(index == candidates.length){
            if(target == 0){
                result.add(new ArrayList<>(temp));
            }
            return;
        }


        if(candidates[index] <= target){
            temp.add(candidates[index]);
            findCombinationSum(index, candidates, target - candidates[index], result, temp);
            temp.remove(temp.size() - 1);
        }

        findCombinationSum(index + 1, candidates, target, result, temp);
    }
}