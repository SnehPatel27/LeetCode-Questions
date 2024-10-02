class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int arr2[] = new int[arr.length];
        Map<Integer, Integer> result = new HashMap<>();


        for(int i=0; i<arr.length; i++){
            arr2[i] = arr[i];
        }

        Arrays.sort(arr2);
        int k = 1;
        for(int i=0;i<arr2.length;i++){
            if(!result.containsKey(arr2[i])){
                result.put(arr2[i], k);
                k++;
            }
        }

        for(int i=0;i<arr.length;i++){
            arr[i] = result.get(arr[i]);
        }

        return arr;
    }
}