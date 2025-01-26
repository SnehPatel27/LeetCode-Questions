class Solution {
    public int minimumOperations(int[] nums) {
        HashSet<Integer> res = new HashSet<>();

        for(int i: nums){
            if(i != 0){
                res.add(i);
            }
        }   

        return res.size();
    }
}