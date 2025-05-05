class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int[] result = new int[n];
        for(int i = n - 1; i >= 0; i--){
            int count = 0;
            while(!st.isEmpty() && heights[i] > heights[st.peek()]){
                st.pop();
                count++;
            }

            if(!st.isEmpty()){
                count++;
            }

            result[i] = count;
            st.push(i);
        }

        return result;
    }
}