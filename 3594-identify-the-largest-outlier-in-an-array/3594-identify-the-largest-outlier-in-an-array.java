class Solution {
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