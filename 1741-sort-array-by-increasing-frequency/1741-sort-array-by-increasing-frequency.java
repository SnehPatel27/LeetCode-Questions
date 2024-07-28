import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for(int number: nums){
            frequency.put(number, frequency.getOrDefault(number, 0) + 1);
        }

        Integer[] numsobject = new Integer[nums.length];

        for(int i=0;i<nums.length;i++){
            numsobject[i] = nums[i];
        }

        Arrays.sort(numsobject, (a,b) -> {
            if(frequency.get(a) == frequency.get(b)){
                return Integer.compare(b,a);
            }else{
                return Integer.compare(frequency.get(a), frequency.get(b));
            }
        });

        for(int i=0;i<nums.length;i++){
            nums[i] = numsobject[i];
        }
        return nums;
    }
}