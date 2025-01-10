class Solution {

    public Boolean isVowel(Character c){
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    public int countVowelSubstrings(String word) {
        
        int n = word.length();
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            Map<Character, Integer> freq = new HashMap<>();
            for(int j = i; j < n; j++){
                if(isVowel(word.charAt(j))){
                    freq.put(word.charAt(j), freq.getOrDefault(word.charAt(j), 0) + 1);
                    if(freq.size() == 5){
                        System.out.println(word.substring(i, j + 1));
                        ans++;
                    }
                } else {
                    break;
                }
            }
        }

        return ans;
    }
}