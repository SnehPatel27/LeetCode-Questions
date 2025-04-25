class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        while(low <= high){
            if((low >= 1 && low <= 9) || (low >= 100 && low <= 999)){
                low++;
                continue;
            }

            String number = Integer.toString(low);
            int len = number.length();

            String firstHalf = number.substring(0, len / 2);
            String secondHalf = number.substring(len / 2, len);

            int i = 0;

            int firstHalfSum = 0;
            int secondHalfSum = 0;

            while(i < firstHalf.length()){

                char c1 = firstHalf.charAt(i);
                char c2 = secondHalf.charAt(i);

                firstHalfSum += (int)c1; 
                secondHalfSum += (int)c2;

                i++;
            }

            if(firstHalfSum == secondHalfSum){
                count++;
            }

            low++;
        }

        return count;
    }
}