class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> mapping = new HashMap<>();
        mapping.put('I', 1);
        mapping.put('V', 5);
        mapping.put('X', 10);
        mapping.put('L', 50);
        mapping.put('C', 100);
        mapping.put('D', 500);
        mapping.put('M', 1000);

        int num = 0;

        for(int i = 0; i < s.length(); i++){
            char currentChar = s.charAt(i);
            if(i+1 < s.length() && mapping.get(currentChar) < mapping.get(s.charAt(i + 1))){
                num -= mapping.get(currentChar); 
            }else{
                num += mapping.get(currentChar);
            }
        }

        return num;
    }
}