class Solution {
    // public boolean isAnagram(String s, String t) {
    //     if(s.length() != t.length()){
    //         return false;
    //     }

    //     HashMap<Character, Integer> smap = new HashMap<>();
    //     HashMap<Character, Integer> tmap = new HashMap<>();

    //     for(int i = 0 ; i < s.length(); i++){
    //         smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
    //         tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
    //     }
    //     return smap.equals(tmap);
    // }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        s.toUpperCase();
        t.toUpperCase();

        int count[] = new int[26];

        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < t.length(); i++){
            count[t.charAt(i) - 'a']--;
        }

        for(int val: count){
            if(val != 0 ){
                return false;
            }
        }

        return true;
    }
}