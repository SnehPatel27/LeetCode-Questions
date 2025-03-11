class Solution {

    public int trap1(int[] height) {
        
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

    //This is the brute force solution computing the left and right max before and using extra storage.
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        // Build the leftMax array
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        
        // Build the rightMax array
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        
        // Calculate total trapped water
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        
        return total;
    }
}