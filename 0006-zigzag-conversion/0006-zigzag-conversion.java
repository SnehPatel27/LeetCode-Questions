class Solution {
    public String convert(String s, int numRows) {
        
        if(s.length() < numRows || numRows == 1) return s;
        
        StringBuilder res = new StringBuilder();

        List<Character>[] cArray = new List[numRows];

        for(int i = 0; i < numRows; i++){
            cArray[i] = new ArrayList<>();
        }

        int index = 0;
        int d = 0;

        for(char c: s.toCharArray()){
            cArray[index].add(c);
            if(index == 0) d = 1;

            if(index == numRows - 1) d = -1;

            index += d;
        }

        for(List<Character> chr: cArray){
            for(int i = 0; i < chr.size(); i++){
                res.append(chr.get(i));
            }
        }

        return res.toString();
    }
}