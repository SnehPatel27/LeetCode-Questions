class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length - 3; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j = i + 1; j < nums.length - 2; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                int leftpointer = j + 1;
                int rightpointer = nums.length - 1;

                while(leftpointer < rightpointer){
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[leftpointer] + (long)nums[rightpointer];
                
                    if(sum == (long)target){
                        result.add(Arrays.asList(nums[i], nums[j], nums[leftpointer], nums[rightpointer]));

                        leftpointer++;
                        rightpointer--;

                        while(leftpointer < rightpointer && nums[leftpointer] == nums[leftpointer - 1]){
                        leftpointer++;
                        }
                        while(leftpointer < rightpointer && nums[rightpointer] == nums[rightpointer + 1]){
                            rightpointer--;
                        }
                        
                    }
                    else if(sum > (long)target){
                        rightpointer--;
                    }else{
                        leftpointer++;
                    }
                }    
            }
        }
        return result;
    }
}