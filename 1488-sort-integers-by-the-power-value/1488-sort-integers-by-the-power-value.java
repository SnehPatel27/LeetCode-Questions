class Solution {
    public int getKth(int lo, int hi, int k) {
        int arr[] = new int[hi - lo + 1];
        int count = 0;
        List<int[]> list = new ArrayList<>();
        for(int i = lo; i <= hi; i++){
            int[] ans = new int[1];
            list.add(new int[]{i, findPowerValue(i, ans)});
        }

        list.sort((a,b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        return list.get(k - 1)[0];
    }

    public int findPowerValue(int x, int[] ans){
        if(x == 1)
            return ans[0];

        if(x % 2 == 0){
            ans[0] = ans[0] + 1;
            findPowerValue(x/2, ans);
        } else {
            ans[0] = ans[0] + 1;
            findPowerValue(3 * x + 1, ans);
        }

        return ans[0];
    }
}