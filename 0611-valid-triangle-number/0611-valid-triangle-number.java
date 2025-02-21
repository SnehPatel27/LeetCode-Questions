//2 pointer approach 
//Sort the array
//lets say the sorted array is 2,2,3,4
//start k from end which we would consider as third side. 
//take i = 0 and j as k - 1
//Computer j - i if nums[j] + nums[i] > k
//eg nums[i] = 2(first 2) and nums[j] = 3 and nums[k] = 4
//2 + 3 > 4 so all pairs like another 2,3,4 would also be valid so did j - i;
//decrease value of k and then check again till k >= 2.

class Solution {
    public int triangleNumber(int[] nums) {

        Arrays.sort(nums);
        
        int count = 0;
        int n = nums.length;
        for(int k = n - 1; k >= 2; k--){
            int i = 0;
            int j = k - 1;
            while(i < j){
                if(nums[i] + nums[j] > nums[k]){
                    count += (j - i);
                    j--;
                } else {
                    i++;
                }
            }
        }

        return count;
    }
}