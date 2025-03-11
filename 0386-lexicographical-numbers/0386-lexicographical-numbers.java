class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for(int start = 1; start <= 9; start++){
            generateLexicalNumbers(start, n, result);
        }

        return result;
    }

    public void generateLexicalNumbers(int start, int n, List<Integer> result){

        if(start > n) return;

        result.add(start);
        for(int i = 0; i <= 9; i++){
            int newNumber = start * 10 + i;

            if(newNumber <= n){
                generateLexicalNumbers(newNumber, n, result);
            } else {
                break;
            }
        }
    }
}