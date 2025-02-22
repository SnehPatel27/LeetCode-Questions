//In this I have to compute the min of max number of balls in the bag.
//Take an example 9. 
//The max ans that could be possible is 9. 
//The lowest ans that could be possible is 1. 
//We try out all the scenarios and check if its possible to have that as the ans in given operations. 
//Like for eg for 5. 9 can be divided into 5,2,2. So we try for smaller num
//Lets try for 3. 9 can be divided to 3,3,3. possible so lets try smaller. 
//lets try for 2. 9 cannot be divided such that the max ball is 2 in one of the bags in the given number of operations(2).
//So we return 4. 

//Best would be to use binary search in order to do this. 

//In order to figure out if its possible to split the balls to give the given max. 
//for eg for 4. We take ceil of 9/4 and subtract 1 from that. If that is <= maxoperations we can achieve that. 

class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1;
        int high = 0;

        for(int num: nums){
            high = Math.max(high, num);
        }

        high = high - 1;

        while(low <= high){
            int possibleSoln = (low + high) / 2;
            if(isPossible(possibleSoln, nums, maxOperations)){
                high = possibleSoln - 1;
            } else {
                low = possibleSoln + 1;
            }
        }

        return low;
    }

    public boolean isPossible(int mid, int[] nums, int maxOperations){

        int totalOperations = 0;

        for(int num: nums){
            totalOperations += Math.ceil(num / (double)mid) - 1;

            if(totalOperations > maxOperations){
                return false;
            }
        }

        return true;
    }
}