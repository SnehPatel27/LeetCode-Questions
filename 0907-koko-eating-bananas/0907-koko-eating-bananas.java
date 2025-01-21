class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = findMax(piles);   
        int mid, ans = 0;

        System.out.println("The max is" +right);

        while(left <= right){
            mid = (left + right) / 2;
            if(checkTotalHours(piles, mid) <= h){
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public int checkTotalHours(int[] piles, int speed){
        int totalHours = 0;
        for(int i = 0; i < piles.length; i++){
            totalHours += Math.ceil((double)piles[i] / (double)speed);
        }

        return totalHours;
    }

    public int findMax(int[] piles){
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < piles.length; i++){
            if(piles[i] > max){
                max = piles[i];
            }
        }

        return max;
    }
}