class Solution {

    //This is the brute force solution 
    public double BruteForce(double x, int n) {

        if(n == 0) return 1;

        boolean negative = (n < 0)? true: false;
        double num = x;
        n = Math.abs(n);
        while(n > 1){
            x = x * num;
            n--;
        }

        if(negative)
            return 1/x;
        else 
            return x;
    }   

    //This is the optimal approach
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