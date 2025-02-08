class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }

        boolean[] counts = new boolean[arr.length + 1];

        for(int keys: freq.keySet()){
            if(counts[freq.get(keys)]){
                return false;
            }

            counts[freq.get(keys)] = true;
        }

        return true;
    }
}