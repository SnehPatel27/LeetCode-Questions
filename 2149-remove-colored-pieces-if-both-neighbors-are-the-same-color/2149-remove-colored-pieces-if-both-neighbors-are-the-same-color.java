class Solution {
    public boolean winnerOfGame(String colors) {
        char c[] = colors.toCharArray();
        int aliceCount = 0;
        int bobCount = 0;
        for(int i = 1; i < c.length - 1; i++){
            if(c[i] == 'A'){
                if(c[i - 1] == 'A' && c[i + 1] == 'A')  
                    aliceCount++;
            } else {
                if(c[i - 1] == 'B' && c[i + 1] == 'B'){
                    bobCount++;
                }
            }
        }

        return !(aliceCount - bobCount <= 0);
    }
}