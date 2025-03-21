class Solution {
    //Is zero considered a positive number
    //what if the array is like 1,2,3,4. 
    //Should we return -1 or 5?

    public int firstMissingPositive1(int[] nums) {
        boolean[] seen = new boolean[nums.length + 1];
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] > 0 && nums[i] <= n){
                seen[nums[i]] = true;
            }
        }

        for(int i = 1; i <= n; i++){
            if(!seen[i]){
                return i;
            }
        }

        return n + 1;
    }

    //This is using extra space. The question just tells to do in O(1). So this is just the temporary solution
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> numbers = new HashSet<>();

        for(int num: nums){
            if(num <= nums.length)
                numbers.add(num);
        }

        int index = 1;
        while(numbers.contains(index)){
            index++;
        }
        return index;
    }
}