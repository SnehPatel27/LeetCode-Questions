class Solution {
    
    //This solution is only for the case when nums.length <= 100 and nums[i] <= 100
    //Since there are only 100 nos and all the nos are said to be less than 100
    //We iterate from the back and continue moving backward till we dont get the first duplicate from the back. 
    //First duplicate indicates that we would have to delete till that number
    //So then the remaining elements would be i + 1.
    //So to remove those i + 1 elements the number of operation that would be required is i + 1 / 3.
    public int minimumOperations(int[] nums) {
        int[] freq = new int[101];
        Arrays.fill(freq, 0);
        for(int i = nums.length - 1; i >= 0; i--){
            if(++freq[nums[i]] > 1)
                return (int)Math.ceil((double)(i + 1) / 3);
        }

        return 0;
    }
}