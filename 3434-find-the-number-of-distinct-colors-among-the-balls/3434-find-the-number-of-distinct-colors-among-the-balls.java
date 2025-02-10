class Solution {

    //Create a frequency hashmap that calculates the frequency of each color. 
    //Update the frequency when a same ball is being recolored. 
    //If that is not the case and a new ball is being colored then no worries. 
    //In this solution the issue is that in the constraints if is given that limits is larger than the queries.length.
    //So not all balls are labelled so we end up using a lot of space becasue of the limits + 1 factor. 
    //So instead of using an array for storing the labelled balls we can use hashMap.
    //This way it ensures that we store those balls which are labelled.
    public int[] queryResults1(int limit, int[][] queries) {
        
        HashMap<Integer, Integer> colorFrequency = new HashMap<>(); 
        int[] balls = new int[limit + 1];
        int[] res = new int[queries.length];

        
        for(int i = 0; i < queries.length; i++){
            int ball = queries[i][0];
            int color = queries[i][1];

            if(balls[ball] != 0){

                int prevColor = balls[ball];
                colorFrequency.put(prevColor, colorFrequency.get(prevColor) - 1);

                if(colorFrequency.get(prevColor) == 0){
                    colorFrequency.remove(prevColor);
                }
            }

            balls[ball] = color;
            colorFrequency.put(color, colorFrequency.getOrDefault(color, 0) + 1);
            res[i] = colorFrequency.size();
        }

        return res;
    }

    public int[] queryResults(int limit, int[][] queries) {
        
        HashMap<Integer, Integer> colorFrequency = new HashMap<>(); 
        HashMap<Integer, Integer> ballOccurence = new HashMap<>();
        int[] res = new int[queries.length];

        
        for(int i = 0; i < queries.length; i++){
            int ball = queries[i][0];
            int color = queries[i][1];

            if(ballOccurence.containsKey(ball)){

                int prevColor = ballOccurence.get(ball);
                colorFrequency.put(prevColor, colorFrequency.get(prevColor) - 1);

                if(colorFrequency.get(prevColor) == 0){
                    colorFrequency.remove(prevColor);
                }
            }

            ballOccurence.put(ball, color);
            colorFrequency.put(color, colorFrequency.getOrDefault(color, 0) + 1);
            res[i] = colorFrequency.size();
        }

        return res;
    }
}