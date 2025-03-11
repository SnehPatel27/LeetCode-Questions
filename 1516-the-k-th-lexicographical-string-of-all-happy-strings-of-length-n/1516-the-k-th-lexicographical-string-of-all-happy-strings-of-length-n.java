class Solution {
    public String getHappyString(int n, int k) {
        List<String> happyStrings = new ArrayList<>();
        generateHappyStrings(n, happyStrings, "");

        if(happyStrings.size() < k) return "";

        return happyStrings.get(k - 1);
    }

    public void generateHappyStrings(int n, List<String> happyStrings, String currentString){
        
        if(currentString.length() == n){
            happyStrings.add(currentString);
            return;
        }

        for(char c = 'a'; c <= 'c'; c++){
            if(currentString == "" || currentString.charAt(currentString.length() - 1) != c){
                generateHappyStrings(n, happyStrings, currentString + c);
            } else continue;
        }
    }
}