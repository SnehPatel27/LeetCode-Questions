class Solution {

    //int total = 0;

    public int trap(int[] height) {
        
        int leftMax = 0;
        int rightMax = 0; 
        int total = 0;

        int leftPointer = 0;
        int rightPointer = height.length - 1;

        while(leftPointer < rightPointer){
            if(height[leftPointer] <= height[rightPointer]){
                if(leftMax > height[leftPointer]){
                    total = total + (leftMax - height[leftPointer]);
                }else {
                    leftMax = height[leftPointer];
                }
                leftPointer++;
            }
            else
            {
                if(rightMax > height[rightPointer]){
                    total = total + (rightMax - height[rightPointer]);
                }else{
                    rightMax = height[rightPointer];
                }
                rightPointer--;
            }
        }

        return total;
    }

    // public int trap2(int[] height) {
        
    //     for(int i = 0; i < height.length; i++){
    //         if(height[0] == 0){
    //             continue;
    //         }
    //         int start = height[i];
    //         for(int j = i + 1; j < height.length; j++){
    //             if(height[j] >= start){
    //                 int end = height[j];
    //                 calculateWaterStored(start, end, height);
    //                 break;
    //             }
    //         }
    //     }

    //     return total;
    // }

    // public void calculateWaterStored(int start, int end, int[] height){
    //     int min = Math.min(height[start], height[end]);
    //     for(int i = start + 1; i < end; i++){
    //         total = total + (min - height[i]);
    //     }
    // }
}