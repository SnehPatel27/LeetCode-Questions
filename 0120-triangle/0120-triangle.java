class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int n = triangle.size();

        if(triangle.size() == 1) return triangle.get(0).get(0);

        int[][] dp = new int[n][n];

        for(int[] i: dp){
            Arrays.fill(i, -1);
        }

        return minimumTotalHelper(triangle, 0, 0, dp);
    }

    public int minimumTotalHelper(List<List<Integer>> triangle, int row, int col, int[][] dp){

        if(row == triangle.size() - 1){
            return triangle.get(row).get(col);
        }

        if(dp[row][col] != -1) return dp[row][col];
        
        int first = triangle.get(row).get(col) + minimumTotalHelper(triangle, row + 1, col, dp);
        int second = triangle.get(row).get(col) + minimumTotalHelper(triangle, row + 1, col + 1, dp);

        return dp[row][col] = Math.min(first, second);
    }
}