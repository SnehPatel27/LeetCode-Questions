class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        
        // Map to store frequency of characters in t
        Map<Character, Integer> tmap = new HashMap<>();
        // Map to store frequency of characters in current window of s
        Map<Character, Integer> smap = new HashMap<>();
        
        int minLen = Integer.MAX_VALUE; // Minimum length of valid window found so far
        int left = 0;  // Left boundary of window
        int right = 0; // Right boundary of window
        int formed = 0; // Number of characters with matching frequency to tmap
        int minLeft = 0; // Left index where minimum window starts

        // Build tmap: count frequency of each character in t
        for (int i = 0; i < t.length(); i++) {
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int required = tmap.size(); // Number of unique characters to match
        
        // Start sliding window
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            // Add current character to smap
            smap.put(currentChar, smap.getOrDefault(currentChar, 0) + 1);
            
            // If current character is needed and its count matches tmap, increment formed
            if (tmap.containsKey(currentChar) && tmap.get(currentChar).intValue() == smap.get(currentChar).intValue()) {
                formed++;
            }
            
            // Try to shrink window from the left while it is valid
            while (left <= right && formed == required) {
                char remchar = s.charAt(left);
                
                // Update minimum window if current window is smaller
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }
                
                // Remove left character from smap
                smap.put(remchar, smap.get(remchar) - 1);
                
                // If removed character is needed and now window no longer satisfies tmap, decrease formed
                //The second condition checks whether we have removed an important character from the window. 
                if (tmap.containsKey(remchar) && smap.get(remchar) < tmap.get(remchar)) {
                    formed--;
                }
                
                left++; // Shrink window
            }
            
            right++; // Expand window
        }
        
        // If no valid window found, return "", else return the minimum window substring
        return (minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen));
    }
}


/*
Your intuition is sliding window:

Expand the window by moving right pointer and include characters.

As soon as you have all required characters in the window (formed == required),
try to shrink the window by moving left pointer to find smaller valid windows.

Always track the minimum-length window seen so far.

You use two maps:

tmap: frequency count of characters in t.

smap: frequency count of characters currently in the sliding window over s.

When the window contains all needed characters (formed == required), you try shrinking from the left.

At the end, you return the smallest window found. 
*/