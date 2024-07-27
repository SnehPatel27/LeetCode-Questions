import java.util.*;
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Hashtable<Integer, String> ans = new Hashtable<>();
        String[] sorted = new String[names.length];

        for(int i=0; i<names.length;i++){
            ans.put(heights[i], names[i]);
        }

        Arrays.sort(heights);
        for(int i=0;i<heights.length;i++){
            System.out.print(heights[i]+ " ");
        }
        int p=0;
        for(int i=heights.length-1; i>=0;i--){
            sorted[p] = ans.get(heights[i]);
            p++;
        }

        return sorted;
    }   
}