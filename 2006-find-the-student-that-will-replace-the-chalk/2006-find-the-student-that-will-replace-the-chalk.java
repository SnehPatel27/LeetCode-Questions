class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum=0;
        int i;
        long toget;
        for(i=0; i<chalk.length;i++){
            sum = sum + chalk[i];
        }

        k %= sum; 


        for(i=0; i<chalk.length;i++){
            if(chalk[i] > k){
                return i;
            }
            k-=chalk[i];
        }
        return -1;
        // sum = 0;
        // i=0;
        // System.out.println(toget);
        // while(toget >= chalk[i]){
        //     System.out.println(toget+" asf ");
        //     toget-=chalk[i];
        //     i++;
        // }
        // return i;
    }
}