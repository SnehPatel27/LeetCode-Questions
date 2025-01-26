class Solution {

    //if((totalSum - nums[i])/2 == nums[i] && freq.get(nums[i]) < 2) continue; for the case
    //[6,-31,50,-35,41,37,-42,13] output should be -35 but comes out to be 13.
    //TC - O(n), SC - O(n)
    public int getLargestOutlier(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int totalSum = 0;
        for(int i = 0; i < nums.length; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            totalSum += nums[i];
        }

        int sum = 0;
        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(((totalSum - nums[i]) % 2 == 0) && freq.containsKey((totalSum - nums[i])/2)){
                if((totalSum - nums[i])/2 == nums[i] && freq.get(nums[i]) < 2) continue;
                answer = Math.max(answer, nums[i]);
            }
        }

        return answer;
    }
}