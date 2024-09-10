class Solution {
    public boolean isPalindrome(int x) {
        int digit,num=0;
        int check = x;
        if(x < 0){
            return false;
        }
        while(x>0){
            digit = x%10;
            num =  digit + (num * 10);
            x = x/10;
        }  
        System.out.println(num);
        return (num == check);
    }
}