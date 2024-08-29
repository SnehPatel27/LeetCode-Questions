class Solution {
    // public int findMaxLength(int[] nums) {
    //     int len=0;
    //     for(int i=0; i<nums.length;i++){
    //         int zeroes = 0;
    //         int ones = 0;
    //         for(int j=i; j<nums.length;j++){
    //             if(nums[j] == 0){
    //                 zeroes++;
    //             }else{
    //                 ones++;
    //             }
    //             if(zeroes == ones){
    //                 len = Math.max(len, j-i+1);
    //             }
    //         }
    //     }
    //     return len;
    // }

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> test = new HashMap<>();

        int count=0;
        test.put(0,-1);
        int maxlength = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                count = count - 1;
            }else{
                count = count + 1;
            }
            if(test.containsKey(count)){
                maxlength = Math.max(maxlength, i - test.get(count));
            }else{
                test.put(count, i);
            }
        }
        return maxlength;
    }
}