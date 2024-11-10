class Solution {
    public int reverse(int x) {
        boolean negative = (x > 0) ? false : true;

        x = Math.abs(x);
        int reverse = 0, digit;    
        while(x > 0){
            digit = x % 10;
            if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && digit > 7)) return 0;
            if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && digit < -8)) return 0;
            reverse = (reverse * 10) + digit;
            x = x / 10;
        }
        
        return (negative) ? -reverse : reverse;
    }
}