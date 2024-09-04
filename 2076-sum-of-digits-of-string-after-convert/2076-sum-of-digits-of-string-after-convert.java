class Solution {
    public int getLucky(String s, int k) {
        int sum=0;
        int dig;
        int num;
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            num = (int)c - 96;
            while(num > 0){
                dig = num % 10;
                sum+=dig;
                num = num/10;
            }
        }
        System.out.println(sum);
        k = k - 1;
        while(k > 0 && sum > 9){
            num = sum;
            sum = 0;
            while(num > 0){
                dig = num % 10;
                sum+=dig;
                num = num/10;
            }
            k = k - 1;
        }
        return sum;
    }
}