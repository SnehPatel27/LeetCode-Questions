class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;
        for(int i: nums){
            if(freqMap.containsKey(i)){
                count += freqMap.get(i);
            }
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }

        return count;
    }   
}