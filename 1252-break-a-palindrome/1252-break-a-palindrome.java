class Solution {
    public String breakPalindrome(String palindrome) {
        int i = 0;
        int j = palindrome.length();
        char[] word = palindrome.toCharArray();
        while(i <= j){
            if(word[i] == 'a'){
                i++;
                j--;
            } else if(i != word.length / 2){
                word[i] = 'a';
                break;
            } else{
                i++;
                j--;
            }
        }

        if(i > j && palindrome.length() == 1) return "";
        if(i > j) word[palindrome.length() - 1] = 'b';
        
        StringBuilder res = new StringBuilder();
        for(char c: word){
            res.append(c);
        }

        return res.toString();
    }
}