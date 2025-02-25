class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> num = new HashSet<>();

        for(int a: arr){
            if(num.contains(a * 2) || (a % 2 == 0 && num.contains(a / 2)))
                return true;
            num.add(a);
        }

        return false;
    }
}