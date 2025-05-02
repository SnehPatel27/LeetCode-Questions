class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(backtrack(board ,i, j, word, 0)) return true;
            }
        }

        return false;
    }

    public boolean backtrack(char[][] board, int i, int j, String word, int index){
        int rows = board.length;
        int cols = board[0].length;

        if(index >= word.length()) return true;

        if(i < 0 || i == rows || j < 0 || j == cols || board[i][j] != word.charAt(index))
            return false;

        board[i][j] = '*';

        int r[] = {0, 1, 0, -1};
        int c[] = {1, 0, -1, 0};

        for(int d = 0; d < 4; d++){
            if(backtrack(board, i + r[d], j + c[d], word, index + 1))
                return true;
        }

        //If after checking all the four directions we do not find the correct match then at the end we make the board element as it was before and we return false. 
        board[i][j] = word.charAt(index);
        return false;
    }
}

/*Time complexity
You would traverse the matrix once in the worst case. that would be m * n.
The recursive depth in this would be L that is the length of the string. 
In this in the first case you have 4 options. like for instance from A -> B you have 4 choices and then you choose 1. But for the next when you reach B. You cannot come back to A so here you only have 3 options. 

So total time complexity would be O(m * n * 3^L).

Space Complexity: Call stack depth: up to L → O(L)
*/
