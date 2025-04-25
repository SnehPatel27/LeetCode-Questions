//This solution is very general could work for any constraints
class Solution1 {
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

//This solution is the most optimal considering the constraints in this question
class Solution{
    public int countSymmetricIntegers(int low, int high) {
        
        int count = 0;
        for(int i = low; i <= high; i++){
            if(i <= 100 && i % 11 == 0){
                count++;
            }

            if(i > 1000 && i < 10000){
                //Lets say the number is 1124. low / 1000 would be 1.
                //low % 1000 would be 124 and (low % 1000) / 100 would be 1;
                //so a would be 2
                int a = i / 1000 + (i % 1000 / 100);

                //For this i % 10 would be 4 in this case 
                //i % 100 / 10 would be the second digit from right wich is 2.
                int b = i % 10 + (i % 100 / 10);

                if(a == b){
                    count++;
                }
            }
        }

        return count;
    }
}