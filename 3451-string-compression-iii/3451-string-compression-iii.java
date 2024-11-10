class Solution {
    public String compressedString(String word) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        while(i < word.length()){
            int consecutiveCount = 0;
            char currentChar = word.charAt(i);

            while(i < word.length() && consecutiveCount < 9 && currentChar == word.charAt(i)){
                i++;
                consecutiveCount++;
            }

            res.append(consecutiveCount).append(currentChar);
        }

        return res.toString();
    }
}