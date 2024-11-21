class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        return findPeakElement(mat, row, col);

    }

    public int[] findPeakElement(int[][] mat, int row, int col){

        int low = 0, high = col - 1;

        while(low <= high){

            //Compute the mid column
            int mid = (low + high) / 2;

            //Compute the max Element in the Column
            int maxRow = findMaxElement(mat, mid, row);


            //Store the left and the right values of the maxElement in that Column
            int left = (mid - 1 >= 0) ? mat[maxRow][mid - 1] : -1;
            int right = (mid + 1 < col) ? mat[maxRow][mid + 1] : -1;

            //Compare the maxElement in the column with its left and right values
            if(mat[maxRow][mid] > left && mat[maxRow][mid] > right)
                return new int[]{maxRow, mid};
            
            //Shift pointers accordingly
            else if(mat[maxRow][mid] < left)
                high = mid - 1;
            
            else 
                low = mid + 1;
        }

        return new int[]{-1, -1};
    }

    public int findMaxElement(int[][] mat, int col, int row){

        int max = mat[0][col];
        int maxRow = 0;
        for(int i = 1; i < row; i++){
            if(mat[i][col] > max){
                max = mat[i][col];
                maxRow = i;
            }
        }

        return maxRow;
    }
}