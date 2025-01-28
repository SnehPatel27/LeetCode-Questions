class Solution {
    //This is the optimal approach. 
    //The time complexity for this is O(n).
    //Space is constant.
    public int jump(int[] nums) {
        
        int left = 0;
        int right = 0;
        int jumps = 0;
        //For each standing index I would compute the farthest that I can go and the starting point would be the left and 
        //the farthest would be the right. 
        //For instance [2,3,1,1,4] standing at 2. Farthest I can go is right = 1 and the least i can go is left = 3 with jumps = 1.
        //Then I would have a loop from left to right and calculate again the farthest I can go and the least I can go. 
        //Least would always be right + 1. so you can direct make the left pointer as right + 1. 
        //And the right pointer as farthest that you compute.
        //You would do this till the right pointer reaches or exceed n - 1;

        while(right < nums.length - 1){
            int farthest = 0;

            for(int i = left; i <= right; i++){
                farthest = Math.max(farthest, i + nums[i]);
            }

            left = right + 1;
            right = farthest;
            jumps++;
        }

        return jumps;

    }

    //Below two functions are the recursive solution where i find all the optimal paths and then figure out the min.
    //In the worst case (e.g., when nums[i] = n for all i), the solution explores O(n^n) paths.
    //Recursive Depth of o(n).
    //You can optmize this with memoization to make the soln O(nsquare).
    //Create a dp Array of n * n;
    public int jumpRecursive(int[] nums) {
        
        return jumpRecursiveHelper(nums, 0, 0);
    }

    public int jumpRecursiveHelper(int[] nums, int index, int jumps){

        if(index >= nums.length - 1) return jumps;

        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= nums[index]; i++){
            min = Math.min(min, jumpRecursiveHelper(nums, index + i, jumps + 1));
        }

        return min;
    }
}