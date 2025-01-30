class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] starPrefix = new int[n];
        int[] pipeLeftDistance = new int[n];
        int[] pipeRightDistance = new int[n];

        int starCount = 0, lastLeft = -1, lastRight = -1;

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '*'){
                starCount++;
                pipeLeftDistance[i] = lastLeft == -1 ? -1 : i - lastLeft;
            } else {
                lastLeft = i;
                pipeLeftDistance[i] = 0;            
            }

            starPrefix[i] = starCount;
        }

        for(int i = n - 1; i >= 0; i--){
            if(s.charAt(i) == '|'){
                lastRight = i;
                pipeRightDistance[i] = 0;                           
            } else {
                pipeRightDistance[i] = lastLeft == -1 ? -1 : lastRight - i;
            }
        }

        int answer[] = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int left = queries[i][0];
            int right = queries[i][1];

            int pipeAfterX = pipeRightDistance[left] == -1 ? -1 : left + pipeRightDistance[left];
            int pipeAfterY = pipeLeftDistance[right] == -1 ? -1 : right - pipeLeftDistance[right];

            if(pipeAfterX != -1 && pipeAfterY != -1 && pipeAfterX <= pipeAfterY){
                answer[i] = starPrefix[pipeAfterY] - starPrefix[pipeAfterX]; 
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }
}