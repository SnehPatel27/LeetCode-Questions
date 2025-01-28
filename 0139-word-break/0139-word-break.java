class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];

        for(int i = 0; i < s.length(); i++){
            for(String word: wordDict){

                if(i < word.length() - 1)
                    continue;
                
                if(i == word.length() - 1 || dp[i - word.length()]){
                    if(s.substring(i - word.length() + 1, i + 1).equals(word)){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[s.length() - 1];
    }
}

/* Here initially I would iterate over the entire string s and have the substring compare with my words present in the worddict.
But before that I have to check initially that i < word.length - 1. If this condition satisfies I do not need to check as I have less characters on the left to compare with the word. Once this condition gets satisfied. I would check if the num of chars == word.length - 1(i == word.length - 1). Or else even if dp[i - word.length()] is true. Because it might be possible that I have processed the first 4 and only want to check for the next 4. Once this condition is satisfied I compare the substrings and then change the index in the dp array accordingly. Lastly I check the boolean value of the last index in the dp array. */