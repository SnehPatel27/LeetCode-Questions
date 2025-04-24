class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int n = triangle.size();

        if(triangle.size() == 1) return triangle.get(0).get(0);

        int[][] dp = new int[n][n];

        for(int[] i: dp){
            Arrays.fill(i, -1);
        }

        return (triangle.get(0).get(0) + minimumTotalHelper(triangle, 1, 0, dp));
    }

    public int minimumTotalHelper(List<List<Integer>> triangle, int row, int prevIndex, int[][] dp){

        if(row == triangle.size() - 1){
            return Math.min(triangle.get(row).get(prevIndex), triangle.get(row).get(prevIndex + 1));
        }

        if(dp[row][prevIndex] != -1) return dp[row][prevIndex];
        
        int first = triangle.get(row).get(prevIndex) + minimumTotalHelper(triangle, row + 1, prevIndex, dp);
        int second = triangle.get(row).get(prevIndex + 1) + minimumTotalHelper(triangle, row + 1, prevIndex + 1, dp);

        return dp[row][prevIndex] = Math.min(first, second);
    }
}