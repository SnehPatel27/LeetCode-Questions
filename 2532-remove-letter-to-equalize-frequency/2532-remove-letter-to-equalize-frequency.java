class Solution {

    public boolean check(int[] hash){
        int possibleFrequency = -1;

        for(int i = 0; i < 26; i++){
            if(hash[i] != 0){
                if(possibleFrequency == -1) possibleFrequency = hash[i];
                else if(possibleFrequency == hash[i]) continue;
                else return false;
            }
        }

        
        return true;
    }

    public boolean equalFrequency(String word) {
        int[] hash = new int[26];
        for(char ch: word.toCharArray()){
            hash[ch - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(hash[i] != 0){
                hash[i]--;
                if(check(hash)) return true;
                hash[i]++;
            }
        }
        return false;
    }
}