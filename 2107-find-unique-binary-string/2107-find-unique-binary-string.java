class Solution {

    //We would convert each of the inputs in the nums array to the integer base 10 equivalent. 
    //We would store that in the set. 
    //Next we would iterate from 0 to N. 
    //We check for each 0..N if it exists in the set or not. 
    //If yes we continue.
    //If not that would be the answer and we can convert that number to the binary equivalent. 
    //Append 0's before to make it of length N. 
    public String findDifferentBinaryString1(String[] nums) {
        Set<Integer> numbers = new HashSet<>();

        for(String num: nums){
            numbers.add(Integer.parseInt(num,2));
        }

        String result = "";
        int n = nums.length;
        for(int i = 0; i <= n; i++){
            if(!numbers.contains(i)){
                System.out.println(i);
                result = Integer.toBinaryString(i);
                while(result.length() < n){
                    result = "0" + result;
                }
                return result;
            }
        }

        return "";
    }

    //Another approach would be to manually generate a new string that would be different from everyone.
    //Generate the new string such that it differs by exactly 1 in each of the strings. 
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < nums.length; i++){
            res.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        return res.toString();
    }
}