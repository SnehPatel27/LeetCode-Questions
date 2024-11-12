class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int total = 0;
        int rows = costs.length;

        Arrays.sort(costs, new Comparator<int[]>(){
            @Override
            public int compare(int a[], int b[]){
                return ((a[0] - a[1]) - (b[0] - b[1]));
            }
        });

        for(int i = 0; i < rows/2; i++){
            total += costs[i][0];
        }

        for(int i = rows/2; i < rows; i++){
            total += costs[i][1];
        }

        return total;
    }
}