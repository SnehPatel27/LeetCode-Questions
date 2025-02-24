class Solution {
    public int[] minOperations(String boxes) {
        int totalBalls = 0;
        for(int i = 0; i < boxes.length(); i++){
            if(boxes.charAt(i) == '1'){
                totalBalls++;
            } 
        }

        int balls[] = new int[totalBalls];

        int p = 0;
        for(int i = 0; i < boxes.length(); i++){
            if(boxes.charAt(i) == '1')
                balls[p++] = i;
        }

        int answer[] = new int[boxes.length()];
        for(int i = 0; i < boxes.length(); i++){
            int count = 0;
            for(int j = 0; j < totalBalls; j++){
                count += Math.abs(balls[j] - i);
            }   
            answer[i] = count;
        }

        return answer;
    }
}