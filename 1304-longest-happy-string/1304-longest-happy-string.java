class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int curra = 0;
        int currb = 0;
        int currc = 0;
        int total = a + b + c;
        String result = "";

        for(int i = 0; i < total; i++){
            if((a >= b && a >= c && curra != 2) || ( a > 0 && (currb == 2 || currc == 2))){
                result+="a";
                a--;
                curra++;
                currb=0;
                currc=0;
            }
            else if(b >= a && b >= c && currb != 2 || ( b > 0 && (curra == 2 || currc == 2))){
                result+="b";
                b--;
                currb++;
                curra=0;
                currc=0;
            }
            else if(c >= a && c >= b && currc != 2 || ( c > 0 && (curra == 2 || currb == 2))){
                System.out.println("The value of c is "+c);
                result+="c";
                c--;
                System.out.println("The value of c is "+c);
                System.out.println("The value of b is "+b);
                System.out.println("The value of a is "+a);
                currc++;
                curra=0;
                currb=0;
            }
        }

        return result;
    }
}