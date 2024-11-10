class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        performDFS(0, 0, "", res, n);

        return res;
    }

    public void performDFS(int openB, int openC, String s, List<String> res, int n){
        if(openC == openB && openC + openB == 2 * n){
            res.add(s);
            return;
        }

        if(openB < n){
            performDFS(openB + 1, openC, s + "(", res, n);
        }

        if(openC < openB){
            performDFS(openB, openC + 1, s + ")", res, n);
        }
    }
}