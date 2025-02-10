class Solution {
    public int getKth(int lo, int hi, int k) {
        int arr[] = new int[hi - lo + 1];
        int count = 0;
        List<int[]> list = new ArrayList<>();
        for(int i = lo; i <= hi; i++){
            list.add(new int[]{i, findPowerValue(i)});
        }

        list.sort((a,b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        return list.get(k - 1)[0];
    }

    public int findPowerValue(int x){
        if(x == 1)
            return 0;

        if(x % 2 == 0){
            return 1 + findPowerValue(x/2);
        } else {
            return 1 + findPowerValue(3 * x + 1);
        }
    }
}