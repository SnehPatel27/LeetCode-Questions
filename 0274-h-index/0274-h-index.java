class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int hIndex = 0;
        int[] countingSort = new int[n + 1];

        for(int i = n; i >= 1; i--){
            countingSort[i] = citations[n - i];
        }

        for(int i = 1; i <= n; i++){
            if(i <= countingSort[i]){
                hIndex = Math.max(hIndex, i);
            }
        }

        return hIndex;
    }
}