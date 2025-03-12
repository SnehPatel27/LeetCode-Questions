class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
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
}