class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];

        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i],0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];

        for(int i = 0; i <= nums.length; i++){
            bucket[i] = new ArrayList<>();
        }

        for(int keys: freq.keySet()){
            bucket[freq.get(keys)].add(keys);
        }
        int p = 0;
        for(int i = bucket.length - 1; i >= 0 && p < k; i--){
            for(int n: bucket[i]){
                result[p++] = n;
                if(p == k){
                    return result;
                }
            }
        }

        return result;
    }
}