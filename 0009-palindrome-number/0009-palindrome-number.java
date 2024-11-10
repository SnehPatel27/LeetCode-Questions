class Solution {
    public boolean isPalindrome(int x) {
        
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
        
        // int digit,num=0;
        // int check = x;
        // if(x < 0){
        //     return false;
        // }
        // while(x>0){
        //     digit = x%10;
        //     num =  digit + (num * 10);
        //     x = x/10;
        // }  
        // System.out.println(num);
        // return (num == check);
    }
}