class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        findAllPermutations(result, temp, nums, freq);

        return result;
    }

    public void findAllPermutations(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] freq){

        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(!freq[i]){
                temp.add(nums[i]);
                freq[i] = true;
                findAllPermutations(result, temp, nums, freq);
                temp.remove(temp.size() - 1);
                freq[i] = false;
            }
        }
    }
}

/*
You are generating all permutations of nums.

For an array of size n, the number of permutations = n! (n factorial).

For each permutation path, you are doing O(n) operations:
Inserting elements into temp
Copying temp into result
Managing recursion stack 

Time Complexity = O(n × n!)

Space Complexity:
temp list → O(n)
freq array → O(n)
Recursion stack → O(n) depth
result list stores n! permutations, each of size n.
*/