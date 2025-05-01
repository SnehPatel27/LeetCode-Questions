//Every number can be written as the product of prime number. In this case you only need to see if the number can be achived by multiplying 2,3,5. So just keep on dividing the number by them till it is possible and at the end check if n == 1 or we have been able to successfully divide the number and reached 1. If yes return true or else return false. 
class Solution {
    public boolean isUgly(int n) {

        if(n <= 0) return false;

        int[] primes = {2,3,5};

        for(int p: primes){
            while(n % p == 0){
                n /= p;
            }
        }

        return n == 1 ? true : false;
    }
}