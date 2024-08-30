class Solution {
    public int subarraySum(int[] nums, int k) {
        //brute force
        // int sum = 0;
        // int ans = 0;
        // for(int i=0;i<nums.length;i++){
        //     sum=0;
        //     for(int j=i;j<nums.length;j++){
        //         sum = sum + nums[j];
        //         if(sum == k){
        //             ans++;
        //         }
        //     }
        // }
        // return ans;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int diff = 0;
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
            if(map.containsKey(sum - k)){
                System.out.println(map.get(sum-k));
                ans = ans + map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
