class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        
        Map<Character, Integer> tmap = new HashMap<>();
        Map<Character, Integer> smap = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        int left=0;
        int formed=0;
        int right=0;
        int minLeft=0;
        for(int i=0;i<t.length();i++){
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i),0)+1);
        }
        int required = tmap.size();
        for(int i=0;i<s.length();i++){
            char currentChar = s.charAt(i);
            smap.put(currentChar, smap.getOrDefault(currentChar,0)+1);
            if(tmap.containsKey(currentChar) && tmap.get(currentChar).intValue() == smap.get(currentChar).intValue()){
                formed++;
            }
            while(left <= right && formed==required){
                char remchar = s.charAt(left);
                if(right-left+1 < minLen){
                    minLen = right-left+1;
                    minLeft = left;
                }
                smap.put(remchar, smap.get(remchar)-1);
                if(tmap.containsKey(remchar) && smap.get(remchar) < tmap.get(remchar)){
                    formed--;
                }
                left++;
            }
            right++;
        }
        return (minLen == Integer.MAX_VALUE ? "":s.substring(minLeft, minLeft+minLen));
    }
}