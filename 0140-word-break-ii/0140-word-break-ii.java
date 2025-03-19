class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictClone = new HashSet<>(wordDict);
        List<String> result = new ArrayList<>();
        StringBuilder currentString = new StringBuilder();
        backTrack(wordDictClone, result, 0, s, currentString);
        return result;
    }

    public void backTrack(Set<String> wordDict, List<String> result, int index, String s, StringBuilder currentString){

        if(s.length() == index){
            result.add(currentString.toString().trim());
            return;
        }
        
        for(int j = index; j < s.length(); j++){
            String currentWord = s.substring(index, j + 1);
            if(wordDict.contains(currentWord)){
                System.out.println(currentWord);
                int currentLength = currentString.length();
                currentString.append(currentWord).append(" ");
                backTrack(wordDict, result, j + 1, s, currentString);
                currentString.setLength(currentLength);
            }
        }
    }
}