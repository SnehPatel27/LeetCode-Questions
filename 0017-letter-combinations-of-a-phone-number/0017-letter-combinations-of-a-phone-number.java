class Solution {

    HashMap<Character, String> mapping = new HashMap<>();
    
    public Solution() {
        mapping.put('2', "abc");
        mapping.put('3', "def");
        mapping.put('4', "ghi");
        mapping.put('5', "jkl");
        mapping.put('6', "mno");
        mapping.put('7', "pqrs");
        mapping.put('8', "tuv");
        mapping.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {

        List<String> combinations = new ArrayList<>();

        if(digits.length() == 0){
            return combinations;
        }
            

        backtrack(digits, 0, combinations);
        return combinations;
    }

    StringBuilder path = new StringBuilder();

    public void backtrack(String digits, int index, List<String> combinations){
        if(path.length() == digits.length()){
            combinations.add(path.toString());
            return;
        }

        String letters = mapping.get(digits.charAt(index));
        for(char c: letters.toCharArray()){
            path.append(c);
            backtrack(digits, index + 1, combinations);
            path.deleteCharAt(path.length() - 1);
        }
    }
}