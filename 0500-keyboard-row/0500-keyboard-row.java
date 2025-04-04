class Solution {
    public String[] findWords(String[] words) {
        
        List<String> list = new ArrayList<>();

        for(String word: words){
            String newWord = word.toLowerCase();
            char[] chars = newWord.toCharArray();
            int a = 0;
            int b = 0;
            int c = 0;
            int n = word.length();
            for(char ch:chars){
                if (ch == 'q' || ch == 'w' || ch == 'e' || ch == 'r' || ch == 't' || ch == 'y' || ch == 'u' || ch == 'i' || ch == 'o' || ch == 'p'){
                    a++;
                }
                else if (ch == 'a' || ch == 's' || ch == 'd' || ch == 'f' || ch == 'g' || ch == 'h' || ch == 'j' || ch == 'k' || ch == 'l'){
                    b++;
                }
                else if (ch == 'z' || ch == 'x' || ch == 'c' || ch == 'v' || ch == 'b' || ch == 'n' || ch == 'm'){
                    c++;
                }
            }
            if(a == n || b == n || c == n){
                list.add(word);
            }
        }

        String[] result = new String[list.size()];
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }

        return result;
    }
}