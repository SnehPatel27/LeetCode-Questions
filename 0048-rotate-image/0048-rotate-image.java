class Solution {
    public void rotate(int[][] matrix) {
        int temp;
        int k=0;
        int m=0;
        if(matrix.length == 1){
            return;
        }
        for(int i=0;i<matrix.length;i++){
            k = m;
            while(k < matrix[0].length){
                temp = matrix[i][k];
                matrix[i][k] = matrix[k][i];
                matrix[k][i] = temp;

                k++;
            }
            m++;
        }

        System.out.println(matrix[1][1]);
        System.out.println(matrix[0][1]);        
        System.out.println(matrix[1][0]);        

        int length = matrix[0].length / 2;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<length;j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}