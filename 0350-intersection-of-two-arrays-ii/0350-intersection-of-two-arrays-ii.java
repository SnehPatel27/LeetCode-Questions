class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        if(nums2.length < nums1.length){
            return intersect(nums2, nums1);
        }
        
        HashMap<Integer, Integer> freq = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int i: nums1){
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        for(int i: nums2){
            if(freq.containsKey(i)){
                if(freq.get(i) > 0){
                    result.add(i);
                    freq.put(i, freq.get(i) - 1);
                }                
            }
        }

        int a[] = new int[result.size()];

        for(int i = 0; i < result.size(); i++){
            a[i] = result.get(i);
        }

        return a;
    }
}