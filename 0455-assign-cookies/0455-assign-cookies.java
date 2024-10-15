class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int leftpointer = 0;
        int rightpointer = 0;
        int i = 0;

        while(leftpointer < g.length && rightpointer < s.length){
            if(g[leftpointer] <= s[rightpointer]){
                count++;
                leftpointer++;
                rightpointer++;
            }
            else{
                rightpointer++;
            }
        }

        return count;
    }
}