class Solution {
    public boolean isPalindromee(int x) {
        
        String str = Integer.toString(x);

        int left = 0;
        int right = str.length() - 1;

        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }

    public boolean isPalindrome(int x) {

        if(x < 0) return false;
        int num = x;
        
        int reverseNum = 0;
        while(x > 0){
            int unit = x % 10;
            reverseNum = (reverseNum * 10) + unit;
            x = x / 10;
        }

        System.out.println(reverseNum);

        if(num == reverseNum) return true;
        return false;
    }
}