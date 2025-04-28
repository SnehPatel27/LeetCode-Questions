class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int totalRows = image.length;
        int totalCols = image[0].length;

        Queue<int[]> q = new LinkedList<>();

        int[][] result = image;

        int initialColor = image[sr][sc];
        if(initialColor == color) return result;

        image[sr][sc] = color;
        q.offer(new int[]{sr, sc});

        int[][] directions = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};

        while(!q.isEmpty()){
            int[] a = q.poll();

            int currentRow = a[0];
            int currentCol = a[1];

            for(int[] direction: directions){
                int neighborRow = currentRow + direction[0];
                int neighborCol = currentCol + direction[1];

                if(neighborRow >= 0 && neighborRow < totalRows && neighborCol >= 0 && neighborCol < totalCols && image[neighborRow][neighborCol] == initialColor){
                    result[neighborRow][neighborCol] = color;
                    q.offer(new int[]{neighborRow, neighborCol});
                }
            }
        }

        return result;

    }
}