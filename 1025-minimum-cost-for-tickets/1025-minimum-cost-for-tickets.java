class Solution {

    //This is the memoization solution
    public int mincostTickets(int[] days, int[] costs) {
        //The max days can go upto 365. But then there would be a case when 30 days are added
        //So then the days can go upto 365 + 30. 
        Integer[][] dp = new Integer[days.length][396];
        return findMinCost(0, 0, days, costs, dp);   
    }

    public int findMinCost(int index,int daysCovered, int[] days, int[] costs, Integer[][] dp){

        int oneDayPassPrice = 0, sevenDayPassPrice = 0, thirtyDayPassPrice = 0;

        if(index >= days.length) return 0;

        if(dp[index][daysCovered] != null) return dp[index][daysCovered];

        if(days[index] <= daysCovered){
            return dp[index][daysCovered] = findMinCost(index + 1, daysCovered, days, costs, dp);
        }

        
        oneDayPassPrice = costs[0] + findMinCost(index + 1, days[index], days, costs, dp);
        sevenDayPassPrice = costs[1] + findMinCost(index + 1, days[index] + 6, days, costs, dp);
        thirtyDayPassPrice = costs[2] + findMinCost(index + 1, days[index] + 29, days, costs, dp);
        

        return dp[index][daysCovered] = Math.min(oneDayPassPrice, Math.min(sevenDayPassPrice, thirtyDayPassPrice));
    }
}