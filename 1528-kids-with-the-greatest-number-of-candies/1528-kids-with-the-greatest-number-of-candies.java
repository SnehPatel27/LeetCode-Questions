class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy = 0;
        for(int candy: candies){
            maxCandy = Math.max(candy, maxCandy);
        }

        List<Boolean> result = new ArrayList<>();

        for(int i = 0; i < candies.length; i++){
            if(candies[i] + extraCandies >= maxCandy){
                result.add(true);
            } else result.add(false);
        }

        return result;
    }
}