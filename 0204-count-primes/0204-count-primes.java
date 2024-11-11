class Solution {
    public int countPrimes(int n) {
        
        if (n < 3) {
            return 0;
        }
        
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true); // Equivalent to memset in C++
        
        int result = n / 2; // Starting count (excluding even numbers except 2)
        
        for (int i = 3; i * i < n; i += 2) {
            if (isPrime[i]) {
                int d = i * 2;
                for (int j = i * i; j < n; j += d) {
                    if (isPrime[j]) {
                        isPrime[j] = false;
                        result--;
                    }
                }
            }
        }


        return result;
    }

    public int countPrimess(int n) {
        
        if(n < 3) return 0;

        boolean[] res = new boolean[n];
        int mainCount = 1;

        for(int i = 3; i < n; i++){
            res[i] = true;
        }

        for(int i = 3; i * i < n; i = i + 2){
            for(int j = i * i; j < n; j += i){
                res[j] = false;
            }
        }

        for(int i = 3; i < n; i = i + 2){
            
            if(res[i]){
                System.out.println(i);
                mainCount++;
            };
        }


        return mainCount;
    }
}