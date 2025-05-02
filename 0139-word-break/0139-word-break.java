class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i] will be true if s[0..i] can be segmented using words from wordDict
        boolean[] dp = new boolean[s.length()];

        // Loop through each character position in the string s
        for (int i = 0; i < s.length(); i++) {

            // Try every word in the dictionary
            for (String word : wordDict) {

                // If the current index i is smaller than word length - 1,
                // we can't match the word ending at position i
                if (i < word.length() - 1)
                    continue;

                // Now we check if:
                // 1. We are at the start of the string and word itself fits (i == word.length() - 1)
                //    → means we're trying to match the prefix s[0..i] directly with a word
                // OR
                // 2. The previous segment s[0..(i - word.length())] was valid (dp[i - word.length()] == true)
                if (i == word.length() - 1 || dp[i - word.length()]) {

                    // Extract the substring ending at position i with length = word.length()
                    // and compare it to the current word in the dictionary
                    if (s.substring(i - word.length() + 1, i + 1).equals(word)) {
                        dp[i] = true; // We found a valid segment ending at i
                        break;        // No need to check other words; move to next i
                    }
                }
            }
        }

        // Final result: can we segment the entire string s[0..n-1]?
        return dp[s.length() - 1];
    }
}

/* Here initially I would iterate over the entire string s and have the substring compare with my words present in the worddict.
But before that I have to check initially that i < word.length - 1. If this condition satisfies I do not need to check as I have less characters on the left to compare with the word. Once this condition gets satisfied. I would check if the num of chars == word.length - 1(i == word.length - 1). Or else even if dp[i - word.length()] is true. Because it might be possible that I have processed the first 4 and only want to check for the next 4. Once this condition is satisfied I compare the substrings and then change the index in the dp array accordingly. Lastly I check the boolean value of the last index in the dp array. */