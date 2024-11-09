class Solution {
    public double myPow(double x, int n) {
        
        return calPower(x, (long) n);
    }

    public double calPower(double x, long n){
        if(n == 0) return 1;

        if(n < 0) return 1 / calPower(x, -n);

        if(n % 2 == 1){
            return x * calPower(x * x, (n - 1)/2);
        }else{
            return calPower(x * x, (n/2));
        }
    }
}