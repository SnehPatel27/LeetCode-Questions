class Solution {
    
    //Bute Force Solution
    public void moveZeroes(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        int n = nums.length;
        
        for(int i = 0; i < n; i++){
            if(nums[i] != 0){
                temp.add(nums[i]);
            }
        }

        for(int i = 0; i < temp.size(); i++){
            nums[i] = temp.get(i);
        }

        for(int i = temp.size(); i < n; i++){
            nums[i] = 0;
        }
    }
}