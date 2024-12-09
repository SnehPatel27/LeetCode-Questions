class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        List<List<Integer>> result = new ArrayList<>();

        int minDifference = Integer.MAX_VALUE;

        for(int i = 1; i < arr.length; i++){
            if(arr[i] - arr[i - 1] < minDifference)
                minDifference = arr[i] - arr[i - 1];
        }

        for(int i = 1; i < arr.length; i++){
            if(arr[i] - arr[i - 1] == minDifference){
                result.add(new ArrayList<>(Arrays.asList(arr[i - 1], arr[i])));
            }
        }

        return result;
    }
}