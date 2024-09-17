class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int num: nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for(int keys: count.keySet()){
            if(count.get(keys) > nums.length/3){
                result.add(keys);
                if(result.size() == 2){
                    break;
                }
            }
        }

        return result;
    }
}