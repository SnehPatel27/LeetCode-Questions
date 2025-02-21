class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        HashSet<String> seen = new HashSet<>();
        List<String> res = new ArrayList<>();
        for(int i = 0; i < n - 9; i++){
            String currentWindow = s.substring(i, i + 10);
            if(seen.contains(currentWindow)){
                if(!res.contains(currentWindow)){
                    res.add(currentWindow);
                }
            } else {
                seen.add(currentWindow);
            }
        }

        return res;   
    }
}