class Solution {
    public int[] minOperations_Brute(String boxes) {
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

    public int[] minOperations(String boxes){

        int n = boxes.length();
        int ballsToLeft = 0;

        int[] prefixSumLeft = new int[n];
        prefixSumLeft[0] = 0;

        for(int i = 0; i < n; i++){
            if(i > 0)
                prefixSumLeft[i] = ballsToLeft + prefixSumLeft[i - 1];
            if(boxes.charAt(i) == '1'){
                ballsToLeft += 1;
            }
        }

        int[] prefixSumRight = new int[n];
        prefixSumRight[n - 1] = 0;
        int ballsToRight = 0;
        for(int i = n - 1; i >= 0; i--){
            if(i < n - 1)
                prefixSumRight[i] += prefixSumRight[i + 1] + ballsToRight;
            if(boxes.charAt(i) == '1'){
                ballsToRight += 1;
            }
        }

        for(int i = 0; i < n; i++){
            prefixSumLeft[i] = prefixSumLeft[i] + prefixSumRight[i];
        }

        return prefixSumLeft;
    }
}