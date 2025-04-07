/*
Start from the left half of the string.
1) Replace the first non-'a' character with 'a'.
2) Skip the middle character in case the string length is odd — replacing the middle character still results in a palindrome.
3) If all characters are 'a', replace the last character with 'b' (to make it not a palindrome and still smallest lex).
*/

class Solution {
    public String breakPalindrome(String palindrome) {

        int i = 0;
        int j = palindrome.length();

        if(j == 1) return "";

        char[] word = palindrome.toCharArray();
        while(i < j / 2){
            if(word[i] != 'a'){
                word[i] = 'a';
                return new String(word);
            }
            i++;
        }

        word[j - 1] = 'b';
        return new String(word);
    }
}