//In this approach the main deciding factor is the pairs. For any string to be a palindrom it should have the (length of String / 2) pairs. It can be of a same character or of different character. Lets say for instance the test case is ["abbb","ba","aa"] - there are total of 4 pairs. Now you check for the smallest length word. It would need 1 pair(because word length is 2). You decrement the count of total pairs and then continue with the next word. Now if in case you x pairs left and the next smallest word requires more then x pairs. Then in that case you would not be able to form any more plaindrome words. So you return i which is indexed from 0. If all the pairs are suffecient at the end you return n which is the length of the words array. 

//lets take an example of test case ["abc", "abd", "ab"]. Total pairs would be 2 (a - 3, b - 3, c - 1, d - 1). For the first word "ab" You use one pair. Total pair now 1. For the next word. You need 1 pair. so you have now 1 pair left. You use that. Next you have 0 pairs so returned value is 2. 

//Question might come as when checking for the word of length 3. We only used 1 pair. What about the last single character word that also needs to be there. So in this case it is assumed that you would have that character anyways. Because if the total length of all the words is 8 and you only have 2 pairs formed. You would at the end have those 4 single frequency characters left which you can use in the odd length words. You can use them 4 times as long as you have equivalent pairs. 

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