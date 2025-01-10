class Solution {
    
    //Bute Force Solution
    public void moveZeroess(int[] nums) {
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

    //optimal Approach
    public void moveZeroes(int[] nums) {
        
        int j = -1;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                j = i;
                break;
            }
        }

        if(j == -1) return;

        for(int i = j + 1; i < n; i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                j++;
            }
        }
    }
}