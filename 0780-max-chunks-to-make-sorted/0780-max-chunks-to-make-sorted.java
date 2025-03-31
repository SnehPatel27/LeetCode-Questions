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