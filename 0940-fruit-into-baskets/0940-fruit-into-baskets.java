class Solution {
    //In case of Inteview please show this 
    public int totalFruitt(int[] fruits) {
        HashMap<Integer, Integer> result = new HashMap<>();
        int n = fruits.length;

        int leftPointer = 0;
        int rightPointer = 0;

        int maxLen = 0;

        while(rightPointer < n){
            
            result.put(fruits[rightPointer], result.getOrDefault(fruits[rightPointer], 0) + 1);

            while(result.size() > 2){
                int leftFruit = fruits[leftPointer];
                result.put(leftFruit, result.get(leftFruit) - 1);

                if(result.get(leftFruit) == 0){
                    result.remove(leftFruit);
                }

                leftPointer++;
            }

            maxLen = Math.max(maxLen, rightPointer - leftPointer + 1);
            
            rightPointer++;
        }

        return maxLen;
    }

    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> result = new HashMap<>();
        int n = fruits.length;

        int leftPointer = 0;
        int rightPointer = 0;

        int maxLen = 0;

        while(rightPointer < n){
            
            result.put(fruits[rightPointer], result.getOrDefault(fruits[rightPointer], 0) + 1);

            if(result.size() > 2){
                int leftFruit = fruits[leftPointer];
                result.put(leftFruit, result.get(leftFruit) - 1);

                if(result.get(leftFruit) == 0){
                    result.remove(leftFruit);
                }

                leftPointer++;
            }

            if(result.size() <= 2){
                maxLen = Math.max(maxLen, rightPointer - leftPointer + 1);
            }
            
            rightPointer++;
        }

        return maxLen;
    }
}