class Solution {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int area = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && heights[i] < heights[st.peek()]){
            
                int currentElement = st.pop();
                int previousSmaller = st.isEmpty() ? -1 : st.peek();
            
                area = Math.max(area, heights[currentElement] * (i - previousSmaller - 1));
            }

            st.push(i);
        }

        while(!st.isEmpty()){
            int current = st.pop();
            int nextSmaller = n;
            int previousSmaller = st.isEmpty() ? -1 : st.peek();

            area = Math.max(area, heights[current] * (nextSmaller - previousSmaller - 1));
        }

        return area;
    }

    //This is the brute force solution. 
    public int largestRectangleArea1(int[] heights) {
        int n = heights.length;
        int area = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            int minHeight = Integer.MAX_VALUE;
            for(int j = i; j < n; j++){
                minHeight = Math.min(minHeight, heights[j]);
                area = Math.max(area, minHeight * (j - i + 1));
            }
        }

        return area;
    }

    //For each index if you know the previous and the next smaller element you can compute the area.
    //Lets the say for index = 4 (value = 2) 
    //The previous smaller = 1 index = 1
    //The next smaller = none index = 6
    //height = arr[index] = 2 and the width = nse - pse - 1 = 6 - 1 - 1 = 4
    //area = 8.
    //Compute for each and calculate the max.
    public int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        int[] nse = new int[n];
        int[] pse = new int[n];

        int area = Integer.MIN_VALUE;

        calculatePSE(pse, heights);
        calculateNSE(nse, heights);

        for(int i = 0; i < n; i++){
            area = Math.max(area, heights[i] * (nse[i] - pse[i] - 1));
        }

        return area;
    }

    public void calculatePSE(int[] pse, int[] heights){
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        for(int index = 0; index < n; index++){
            while(!st.isEmpty() && heights[st.peek()] > heights[index]){
                st.pop();
            }

            if(st.isEmpty()){
                pse[index] = -1;
            } else {
                pse[index] = st.peek();
            }

            st.push(index);
        }
    }

    public void calculateNSE(int[] nse, int[] heights){
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        for(int index = n - 1; index >= 0; index--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[index]){
                st.pop();
            }

            if(st.isEmpty()){
                nse[index] = n;
            } else {
                nse[index] = st.peek();
            }

            st.push(index);
        }
    }
}