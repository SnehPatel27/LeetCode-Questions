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

        board[i][j] = word.charAt(index);
        return false;
    }
}