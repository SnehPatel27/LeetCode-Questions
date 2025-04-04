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

//If Without using Space

/*
for (int i = 1; i < colors.length() - 1; i++) {
            if (colors.charAt(i) == 'A' &&
                colors.charAt(i - 1) == 'A' &&
                colors.charAt(i + 1) == 'A') {
                aliceCount++;
            } else if (colors.charAt(i) == 'B' &&
                       colors.charAt(i - 1) == 'B' &&
                       colors.charAt(i + 1) == 'B') {
                bobCount++;
            }
        }
*/