class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> result = new HashMap<>();

        for(int i: arr){
            int rem = ((i % k) + k) % k;
            result.put(rem, result.getOrDefault(rem, 0) + 1);
        }   

        for(int i: arr){
            int rem = ((i % k) + k) % k;

            if(rem == 0){
                if(result.get(rem) % 2 == 1){
                    return false;
                }
            }

            else if(!Objects.equals(result.get(rem), result.get(k-rem))){
                return false;
            }

            // if(rem == k/2){
            //     if(k % 2 == 0){
            //         if(result.get(rem) % 2 != 0){
            //             return false;
            //         }
            //     }
            // }
        }

        return true;
    }
}