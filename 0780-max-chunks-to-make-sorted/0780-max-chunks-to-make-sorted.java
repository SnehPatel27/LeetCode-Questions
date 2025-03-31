class Solution {
    public int maxChunksToSorted(int[] arr) {
        int maxElement = Integer.MIN_VALUE;
        int chunks = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > maxElement){
                maxElement = arr[i];
            }
            if(i == maxElement){
                chunks++;
            }
        }

        return chunks;
    }
}

/* Approach 2: Editorial 1: 
new chunk at index i can only be created if all the numbers in the current and previous chunks (the "prefix" of the array) are smaller than all the numbers in the following chunks (the "suffix" of the array). This is equivalent to checking whether:

max(prefix[0:i])<min(suffix[i:n]).
*/