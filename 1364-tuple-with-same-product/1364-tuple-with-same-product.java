class Solution {
    public int tupleSameProduct(int[] nums) {
        Arrays.sort(nums);
        int totalCount = 0;
        int n = nums.length;
        for(int a = 0; a < n; a++){
            for(int b = n - 1; b >= 0; b--){
                int product = nums[a] * nums[b];
                HashSet<Integer> set = new HashSet<>();
                for(int c = a + 1; c < b; c++){
                    if(product % nums[c] == 0){
                        int d = product/nums[c];

                        if(set.contains(d)){
                            totalCount += 8;
                        }

                        set.add(nums[c]);
                    }
                }
            }
        }

        return totalCount;
    }
}