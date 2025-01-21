class Solution {
    public List<String> stringMatching(String[] words) {
        
        List<String> result = new ArrayList<>();

        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words.length; j++){
                if(i == j) continue;
                if(checkSubString(words[i], words[j])){
                    result.add(words[i]);
                    break;
                }
            }
        }

        return result;
    }

    public static boolean checkSubString(String str, String s){
        
        if(s.length() < str.length()) return false;
        for(int i = 0; i <= s.length() - str.length(); i++){
            if(s.substring(i, i + str.length()).equals(str)) return true;
        }
        
        return false;
    }
}