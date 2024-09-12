class Solution {
    public int maxProfit(int[] prices) {
        // int profit;
        // int result=0;
        // for(int i=0; i<prices.length-1;i++){
        //     for(int j=i+1;j<prices.length;j++){
        //         int buy = prices[i];
        //         int sell = prices[j];
        //         profit = sell - buy;
        //         result = Math.max(result, profit);
        //     }
        // }
        // return result;

        int minPrice = Integer.MAX_VALUE;
        int result = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else{
                result = Math.max(result, prices[i] - minPrice);
            }
        }
        return result;
    }
}