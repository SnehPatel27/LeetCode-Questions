class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;

        HashSet<Character>[] rows = new HashSet[n];
        HashSet<Character>[] cols = new HashSet[n];
        HashSet<Character>[] boxes = new HashSet[n];

        for(int i = 0; i < 9; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){

                char val = board[i][j];

                if(val == '.')
                    continue;
                
                if(rows[i].contains(val))
                    return false;
                rows[i].add(val);
                
                if(cols[j].contains(val))
                    return false;
                cols[j].add(val);
                
                int box = (i/3) * 3 + (j/3);
                if(boxes[box].contains(val))
                    return false;
                boxes[box].add(val); 
            }
        }

        return true;
    }
}