import java.util.*;
class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[] finalans = new int[nums.length];
        // Map<Integer, Integer> mapped = new HashMap<>();
        ArrayList<Integer[]> pair = new ArrayList<>();
        
        int p=0;
        for(int i=0; i<nums.length; i++){
            String finalnumber = "";
            String stringnumber = Integer.toString(nums[i]);
            for(int j=0;j<stringnumber.length();j++){
                String replace = Integer.toString(mapping[Character.getNumericValue(stringnumber.charAt(j))]);
                finalnumber = finalnumber+replace;
            }
            int number = Integer.parseInt(finalnumber);
            pair.add(new Integer[] {number, i});
        }

        Collections.sort(pair, new Comparator<Integer[]>(){
            @Override
            public int compare(Integer[] o1, Integer[] o2){
                return o1[0].compareTo(o2[0]);
            }
        });

        int ans[] = new int[nums.length];
        for(int i=0;i<pair.size();i++){
            ans[i] = nums[pair.get(i)[1]];
        }

        return ans;
    }
}