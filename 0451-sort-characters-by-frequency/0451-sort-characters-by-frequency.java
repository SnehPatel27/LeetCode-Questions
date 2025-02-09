class Solution {
    public String frequencySort(String s) {

        //This algorithm uses counting sort 
        HashMap<Character, Integer> freq = new HashMap<>();
        int n = s.length();
        for(int i = 0; i < n; i++){
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }

        List<Character>[] counts = new ArrayList[n + 1];

        for(int i = 0; i <= n; i++){
            counts[i] = new ArrayList<>();
        }

        for(char i: freq.keySet()){
            counts[freq.get(i)].add(i);
        }

        StringBuilder res = new StringBuilder();
        for(int i = n; i >= 0; i--){
            if(counts[i] == null) continue;
            for(char c: counts[i]){
                for(int j = 1; j <= i; j++){
                    res.append(c);
                }
            }
        }

        return res.toString();
    }
}