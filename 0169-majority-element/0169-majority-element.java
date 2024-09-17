class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> result = new HashMap<>();

        for(int num: nums){
            result.put(num, result.getOrDefault(num, 0) + 1);
        }

        for(int key: result.keySet()){
            if(result.get(key) > nums.length / 2){
                return key;
            }
        }

        return -1;
    }
}