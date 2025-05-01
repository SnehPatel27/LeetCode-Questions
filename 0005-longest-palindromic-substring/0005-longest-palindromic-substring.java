class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int left = 0;
        int right = 0;
        int resLength = 0;
        String result = "";
        for(int i = 0; i < n; i++){

            left = i;
            right = i + 1;
            while((left >= 0 && right < n) && (s.charAt(left) == s.charAt(right))){
                if(right - left + 1 > resLength){
                    resLength = right - left + 1;
                    result = s.substring(left, right + 1);
                }

                left--;
                right++;
            }

            left = i;
            right = i;
            while((left >= 0 && right < n) && (s.charAt(left) == s.charAt(right))){
                if(right - left + 1 > resLength){
                    resLength = right - left + 1;
                    result = s.substring(left, right + 1);
                }

                left--;
                right++;
            }
        }

        return result;
    }
}

/*
Time Complexity: O(n²)

You loop through each character in the string s once → O(n)
For each character, you expand outward in both directions (left and right) to check for:
even-length palindromes, odd-length palindromes
In the worst case (e.g., "aaaaa"), expansion takes up to O(n) time for each center. 
*/