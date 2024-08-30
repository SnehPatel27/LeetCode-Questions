class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int leftpointer = 0;
        int rightpointer = numbers.length-1;
        int arr[] = new int[2];
        while(leftpointer <= rightpointer){
            if(numbers[leftpointer] + numbers[rightpointer] == target){
                arr[0] = leftpointer+1;
                arr[1] = rightpointer+1;
                return arr;
            }
            else if(numbers[leftpointer] + numbers[rightpointer] > target){
                rightpointer--;
            }else{
                leftpointer++;
            }
        }
        return arr;
    }
}