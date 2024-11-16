class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> result = new HashSet<>();
        List<Integer> resultant = new ArrayList<>();

        if(nums2.length < nums1.length)
            return intersection(nums2, nums1);

        for(int i: nums1){            
            result.add(i);
        }

        for(int i: nums2){
            if(result.contains(i)){
                resultant.add(i);
                result.remove(i);
            }
        }

        int[] a = new int[resultant.size()];

        for(int i = 0; i < resultant.size(); i++){
            a[i] = resultant.get(i);
        }

        return a;
    }
}