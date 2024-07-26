class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rowlength = rowSum.length;
        int collength = colSum.length;

        int currowSum[] = new int[rowlength];
        int curcolSum[] = new int[collength];

        int origmatrix[][] = new int[rowlength][collength];

        for(int i=0;i<rowlength;i++){
            for(int j=0;j<collength;j++){
                origmatrix[i][j] = Math.min(rowSum[i]-currowSum[i], colSum[j]-curcolSum[j]);

                currowSum[i] += origmatrix[i][j];
                curcolSum[j] += origmatrix[i][j];
            }
        }
        return origmatrix;
    }
}