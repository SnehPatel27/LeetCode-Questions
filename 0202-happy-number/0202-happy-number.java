class Solution {
    public boolean isHappy(int n) {
    int rem=0;
    while(n>9){
        int sum=0;
            while(n != 0){
                rem = n%10;
                sum = sum + rem*rem;
                n = n/10;
            }
            n = sum;
        }
        if(n == 1 || n == 7){
            return true;
        }
        return false;
    }
}