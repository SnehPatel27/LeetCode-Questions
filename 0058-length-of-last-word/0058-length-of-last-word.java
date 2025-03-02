class Solution {
    
    //Provide me this one
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int count = 0;
        while(i >= 0){
            if(s.charAt(i) == ' '){
                i--;
            } else break;
        }

        while(i >= 0 && s.charAt(i) != ' '){
            count++;
            i--;
        }

        return count;
    }

    //Editorial Solution
    public int lengthOfLastWord1(String s) {
        int p = s.length(), length = 0;
        while (p > 0) {
            p--;
            // we're in the middle of the last word
            if (s.charAt(p) != ' ') {
                length++;
            }
            // here is the end of last word
            else if (length > 0) {
                return length;
            }
        }
        return length;
    }
}