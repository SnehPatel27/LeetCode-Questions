class Solution {
    public int countPalindromicSubsequence(String s) {
        
        Map<Character, Integer> res = new HashMap<>();
        Set<String> r = new HashSet<>();
        Set<Character> left = new HashSet<>();

        for(int i = 0; i < s.length(); i++){
            res.put(s.charAt(i), res.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i = 0; i < s.length(); i++){   
            res.put(s.charAt(i), res.get(s.charAt(i)) - 1);

            for(char j: left){
                if(res.getOrDefault(j, 0) > 0)
                    r.add(j + " " + s.charAt(i) + " " +j);
            }

            left.add(s.charAt(i));
        }
        return r.size();
    }
}