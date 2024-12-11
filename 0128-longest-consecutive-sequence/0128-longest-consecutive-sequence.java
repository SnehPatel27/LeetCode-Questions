class Solution {

    // in case of inteview provide this one
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> result = new HashSet<>();

        int longest = 0;
        int n = nums.length;

        if(n == 0){
            return 0;
        }

        for(int i=0;i<n;i++){
            result.add(nums[i]);
        }

        for(int i: result){
            
            if(!result.contains(i - 1)){
                int count = 1;
                int x = i;

                while(result.contains(x+1)){
                    count++;
                    x = x + 1;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }


    public int longestConsecutives(int[] nums) {
        Arrays.sort(nums);
        int lastsmallest = Integer.MIN_VALUE;
        int count = 0;
        int result = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == lastsmallest + 1 || nums[i] == lastsmallest){
                if(nums[i] == lastsmallest + 1){
                    count++;
                    lastsmallest = nums[i];
                }else{
                    continue;
                }
            }else{
                count = 1;
                lastsmallest = nums[i];
            }
            result = Math.max(count, result);
        }
        return result;
    }
}