class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int n = words.length;
        int[] A = new int[n];

        for(int i = 0; i < n; i++){
            A[i] = words[i].length();
        }
        
        int pairs = 0;
        Arrays.sort(A);

        for(String word: words){
            for(char c: word.toCharArray()){
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            }
        }

        for(int num: freqMap.values()){
            pairs += num / 2;
        }
        System.out.println(pairs);
        for(int i = 0; i < n; i++){
            int currentLength = A[i];
            pairs -= currentLength / 2;

            if(pairs < 0){
                return i;
            }
        }

        return n;
    }
}