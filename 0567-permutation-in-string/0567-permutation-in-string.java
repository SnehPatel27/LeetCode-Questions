//One of the solution is to sort the shorter string s1 and then compare the window of sorted s1.length() characters in s2 and check if they are same or not. If yes return true or at the end return false. 
class Solution1 {
    public boolean checkInclusion(String s1, String s2) {
        
        s1 = sort(s1);

        for(int i = 0; i <= s2.length() - s1.length(); i++){
            if(s1.equals(sort(s2.substring(i, i + s1.length())))){
                return true;
            }
        }
        return false;
    }

    public String sort(String s){
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}

//Another Solution would be to create a hashMap for s1 and then for every window of s2 create a hashMap of s2 and at every intervals compare both the hashMaps. If they are same return true or else return false. 
class Solution2 {
    public boolean checkInclusion(String s1, String s2) {   
        HashMap<Character, Integer> s1Map = new HashMap<>();

        int s1Len = s1.length();
        int s2Len = s2.length();

        //Create s1Map
        for(int i = 0; i < s1Len; i++){
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for(int i = 0; i <= s2Len - s1Len; i++){
            HashMap<Character, Integer> s2Map = new HashMap<>();
            for(int j = 0; j < s1Len; j++){
                s2Map.put(s2.charAt(i + j), s2Map.getOrDefault(s2.charAt(i + j), 0) + 1);
            }

            if(matches(s1Map, s2Map)){
                return true;
            }
        }

        return false;
    }

    public boolean matches(HashMap<Character, Integer> s1Map, HashMap<Character, Integer> s2Map){
        for(char c: s1Map.keySet()){
            if(s1Map.get(c) - s2Map.getOrDefault(c, 0) != 0){
                return false;
            }
        }

        return true;
    }
}

//We keep a fixed size array of length 20. As we go over the window we can simple update it. So we would remove the character that is no longer the part of the window and we would add the new one that is now the part. Each time we compare the elements to check if everything matches up for the results or not. 
class Solution {
    public boolean checkInclusion(String s1, String s2) {   
        
        int s1Arr[] = new int[26];
        int s2Arr[] = new int[26];

        int s1Len = s1.length();
        int s2Len = s2.length();

        if(s2Len < s1Len) return false;

        for(int i = 0; i < s1Len; i++){
            s1Arr[s1.charAt(i) - 'a']++;
            s2Arr[s2.charAt(i) - 'a']++;
        }

        for(int i = 0; i < s2Len - s1Len; i++){
            if(matches(s1Arr, s2Arr)){
                return true;
            }

            s2Arr[s2.charAt(i + s1Len) - 'a']++;
            s2Arr[s2.charAt(i) - 'a']--;
        }

        if(matches(s1Arr, s2Arr)){
            return true;
        }

        return false;
    }

    public boolean matches(int[] s1Arr, int[] s2Arr){
        for(int i = 0; i < 26; i++){
            if(s1Arr[i] != s2Arr[i]){
                return false;
            }
        }
        return true;
    }
}