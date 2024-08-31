class Solution {
    // public double findMaxAverage(int[] nums, int k) {
    //     System.out.println(nums.length);
    //     double average = 0;
    //     double answer = 0;
    //     if(nums.length == 1 && k == 1){
    //         return (double)(nums[0]/k);
    //     }
    //     for(int i=0;i<nums.length-k+1;i++){
    //         double sum=0;
    //         int start = i;
            
    //         while(start < i+k){
    //             sum = sum + nums[start];
    //             start++;
    //         }
    //         answer = Math.max(answer, sum/k);
    //     }
    //     return answer;
    // }
    public double findMaxAverage(int[] nums, int k) {
       int start=0;
       double sum=0;
       double answer = Double.NEGATIVE_INFINITY;
       for(int i=0;i<nums.length;i++){
        sum = sum + nums[i];
            if(i >= k-1){
                double average = (double)sum/k;
                answer = Math.max(answer, average);
                sum = sum - nums[start];
                start++;
            }
        }
        return answer;
    }
}