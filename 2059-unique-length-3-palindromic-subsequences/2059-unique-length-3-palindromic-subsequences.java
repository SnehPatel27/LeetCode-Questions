class Solution {

    //NeetCode

    /* Iterate over the entire array and for each element conpute the strings that can be formed with that character as the 
    middle element. There would be a hashset that would store the strings that can be formed. The output would be the 
    size of the set. */

    /* Initially there would be the hashmap that would store all the frequencies of each character. */

    /* For the first encountered character check if there is any element present in the left hash set and the hashmap both.
    If yes then that 1 string can be formed. but before that remember to decrease the frequency of that element from the right hashmap.  */

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