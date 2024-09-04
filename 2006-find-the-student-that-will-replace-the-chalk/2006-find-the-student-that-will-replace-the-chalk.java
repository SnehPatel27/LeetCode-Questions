class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum=0;
        int i;
        long toget;
        for(i=0; i<chalk.length;i++){
            sum = sum + chalk[i];
        }

        toget = k % sum; 

        sum = 0;
        i=0;
        System.out.println(toget);
        while(toget >= chalk[i]){
            System.out.println(toget+" asf ");
            toget-=chalk[i];
            i++;
        }
        return i;
    }
}