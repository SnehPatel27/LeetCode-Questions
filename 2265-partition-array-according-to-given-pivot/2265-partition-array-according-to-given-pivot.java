class Solution {
    //This approach involves using two seperate lists for greater and smaller elements.
    //It then creates a resultant array from that. 
    public int[] pivotArray1(int[] nums, int pivot) {
        int n = nums.length;

        List<Integer> smallerNumbers = new ArrayList<>();
        List<Integer> biggerNumbers = new ArrayList<>();

        for(int i: nums){
            if(i < pivot){
                smallerNumbers.add(i);
            } else if(i > pivot){
                biggerNumbers.add(i);
            }
        }

        int sameNumbers = n - (smallerNumbers.size() + biggerNumbers.size());

        int[] result = new int[n];

        int counter = 0;
        for(int i = 0; i < smallerNumbers.size(); i++){
            result[counter++] = smallerNumbers.get(i);
        }

        while(sameNumbers > 0){
            result[counter++] = pivot;
            sameNumbers--;
        }

        for(int i = 0; i < biggerNumbers.size(); i++){
            result[counter++] = biggerNumbers.get(i);
        }

        return result;
    }

    //The next approach is to use two pointer. 
    //One pointer starts from front that tracks the smaller elements and increments after each correct placing. 
    //One pointer starts from back that tracks the larger elements and decrements after each correct placing. 
    //after setting all the smaller and the larger elements in the correct position.
    //All the elements betweent the two pointer should be set to the pivot. 
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        int[] result = new int[n];

        for(int i = 0, j = n - 1; i < n && j >= 0; i++, j--){
            if(nums[i] < pivot){
                result[left] = nums[i];
                left++;
            }

            if(nums[j] > pivot){
                result[right] = nums[j];
                right--;
            }
        }

        while(left <= right){
            result[left] = pivot;
            left++;
        }

        return result;
    }
}