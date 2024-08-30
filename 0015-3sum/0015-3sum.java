class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int leftp = i+1;
            int rightp = nums.length-1;

            while(leftp < rightp){
                int total = nums[i] + nums[leftp] + nums[rightp];
                if (total > 0){
                    rightp--;
                }
                else if(total < 0){
                    leftp++;
                }else{
                    answer.add(Arrays.asList(nums[leftp], nums[rightp], nums[i]));
                    leftp++;

                    while(nums[leftp] == nums[leftp-1] && leftp < rightp){
                        leftp++;
                    }
                }
            }
        }
        return answer;
    }
}