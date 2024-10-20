class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();

        for(String word: strs){
            char[] ch = word.toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);

            if(!result.containsKey(sorted)){
                result.put(sorted, new ArrayList<>());
            }

            result.get(sorted).add(word);
        } 

        return new ArrayList<>(result.values());
    }
}