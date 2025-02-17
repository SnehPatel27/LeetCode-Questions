class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        
        int[][] rank = new int[n][n];


        //Create a rank matrix which shows the preference of each with others.
        //Lower rank indicates more preference
        for(int i = 0; i < preferences.length; i++){
            for(int j = 0; j < preferences[i].length; j++){
                rank[i][preferences[i][j]] = j; 
            }
        }

        int[] pairedWith = new int[n];

        //Create a paired array see who is paired with whom
        for(int[] pair: pairs){
            pairedWith[pair[0]] = pair[1];
            pairedWith[pair[1]] = pair[0];
        }

        //If X is paired with Y
        //Check all the friends (U) who are prefered more than Y. 
        //U is paired with V.
        //Check if preference of U for X is more than that for V.
        //rank[u][x] < rank[u][v];
        //If this is the case it means that X should be paired with U rather than Y.
        int unhappyCount = 0;
        for(int x = 0; x < n; x++){
            int y = pairedWith[x];
            for(int i = 0; i < rank[x][y]; i++){
                int u = preferences[x][i];
                int v = pairedWith[u];
                if(rank[u][x] < rank[u][v]){
                    unhappyCount++;
                    break;
                }
            }
        }

        return unhappyCount;
    }
}