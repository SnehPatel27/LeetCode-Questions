class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        if(numRows >= 1){
            result.add(new ArrayList<>(Arrays.asList(1)));
            numRows--;
        }
        int i = 0;
        while(numRows > 0){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            
            for(int j=1; j<result.get(i).size();j++){
                temp.add(result.get(i).get(j) + result.get(i).get(j-1));
            }
            i++;
            temp.add(1);
            result.add(new ArrayList<>(temp));
            numRows--;
        }
        return result;
    }
}