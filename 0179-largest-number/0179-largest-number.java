class Solution {
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(str, (b,a) -> (a+b).compareTo(b+a));

        if(str[0].charAt(0) == '0')
        return "0";

        StringBuilder res = new StringBuilder();
        for(int i = 0; i < str.length; i++){
            res.append(str[i]);
        }

        return res.toString();

    }
}