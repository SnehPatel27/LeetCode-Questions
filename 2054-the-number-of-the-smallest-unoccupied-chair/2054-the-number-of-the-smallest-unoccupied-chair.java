class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        

        int[] target = times[targetFriend];
        Arrays.sort(times, (a,b) -> Integer.compare(a[0], b[0]));

        int[] chairTime = new int[times.length];

        for(int[] a: times){
            for(int i=0; i<times.length; i++){
                if(chairTime[i] <= a[0]){
                    chairTime[i] = a[1];
                    if(Arrays.equals(a, target)) return i;
                    break;
                }
            }
        }

        return 0;
    }
}