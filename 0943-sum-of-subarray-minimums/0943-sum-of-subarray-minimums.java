class Solution {
    
    //This is the brute force solution with TC - O(n square) and SC - contstant
    //generate all subarrays and keep track of the min and find the sum
    public int bruteForce(int[] arr) {
        int mod = (int)(1e9 + 7);
        int sum = 0;
        int min;

        for(int i = 0; i < arr.length; i++){
            min = arr[i];
            for(int j = i; j < arr.length; j++){
                min = Math.min(arr[j], min);
                sum = (sum + min) % mod;
            }
        }

        return sum;
    }

    //This is the optimal approach where you consider how many times a particular number can contribute to the minimum in the 
    //subarray. Like for ex in the first given ex 1 contributes 6 times, 2 2 times and 3 1 time and so on. 
    //For a number to contribute as the min we need to figure how how many times a particular num is the min in the subarrays. 
    //For that for every num will caluculate the index of the next smaller element and the previous smaller element. 
    //till the NSE and PSE are not the part of the subarray the current num would act as the min in the subarray. 
    //so there would be left * right subarrays and * by the curent num would give the sum.
    //We would continue this for all the numbers in the array. 
    public int sumSubarrayMins(int[] arr) {
        int mod = (int)(1e9 + 7);
        int sum = 0;
        
        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);

        for(int i = 0; i < arr.length; i++){
            int left = i - pse[i];
            int right = nse[i] - i;

            sum = (sum + (int)((long) right * left % mod * arr[i] % mod) % mod) % mod;
        }

        return sum;
    }

    public int[] findNSE(int[] arr){
        Stack<Integer> st = new Stack();
        int[] nse = new int[arr.length];

        for(int i = arr.length - 1; i >= 0; i--){
            while(!st.isEmpty() && arr[i] <= arr[st.peek()]){
                st.pop();
            }

            nse[i] = st.isEmpty() ? arr.length : st.peek();

            st.push(i); 
        }

        for(int i = 0; i < nse.length; i++){
            System.out.print(nse[i] + " ");
        }

        System.out.println();

        return nse;
    }

    public int[] findPSE(int[] arr){
        Stack<Integer> st = new Stack();
        int[] pse = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            while(!st.isEmpty() && arr[i] < arr[st.peek()]){
                st.pop();
            }

            pse[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i); 
        }

        for(int i = 0; i < pse.length; i++){
            System.out.print(pse[i] + " ");
        }

        return pse;
    }
}