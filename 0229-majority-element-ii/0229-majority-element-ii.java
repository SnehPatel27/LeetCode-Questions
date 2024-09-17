class Solution {
    // public List<Integer> majorityElement2(int[] nums) {
    //     List<Integer> result = new ArrayList<>();
    //     HashMap<Integer, Integer> count = new HashMap<>();
    //     for(int num: nums){
    //         count.put(num, count.getOrDefault(num, 0) + 1);
    //     }

    //     for(int keys: count.keySet()){
    //         if(count.get(keys) > nums.length/3){
    //             result.add(keys);
    //             if(result.size() == 2){
    //                 break;
    //             }
    //         }
    //     }

    //     return result;
    // }
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer> result = new ArrayList<>();

        int count1=0;
        int count2=0;
        int candidate1 = 0;
        int candidate2 = 0;

        for(int num: nums){
            if(num == candidate1){
                count1++;
            }else if(num == candidate2){
                count2++;
            }else if(count1 == 0){
                candidate1 = num;
                count1++;
            }else if(count2 == 0){
                candidate2 = num;
                count2++;
            }else{
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        System.out.println(candidate1);
        System.out.println(candidate2);

        for(int num: nums){
            if(num == candidate1){
                count1++;
            }
            if(num == candidate2){
                count2++;
            }
        }

        if(count1 > nums.length/3){
            if(count2 > nums.length/3 && candidate1 == candidate2){
                result.add(candidate1);    
                return result;
            }
            result.add(candidate1);
        } 
        if(count2 > nums.length/3){
            result.add(candidate2);
        }   

        return result;
    }
}