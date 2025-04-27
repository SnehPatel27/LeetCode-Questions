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

/*
Time Complexity: O(2^target)
Space Complexity: O(target) 

Every number can be picked multiple times.

Suppose the smallest candidate is 1, then the maximum depth of recursion can be as large as target (because you keep picking small numbers repeatedly until sum reaches target).

O(2^(target + n)) -> But most people simplify it as: O(2^target)

Space would be the recursion depth that would be equal to target in the worst case. 

If you see:
You are trying multiple options (like pick/not pick or multiple numbers).
You are modifying some temporary path/answer during recursion.
You need to undo (remove last choice) after recursion. It is backtracking.
*/