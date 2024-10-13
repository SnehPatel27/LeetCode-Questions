class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        HashMap<Integer, Integer> result = new HashMap<>();
        Stack<Integer> nextgreater = new Stack<>();

        for(int i=0; i<nums1.length; i++){
            result.put(nums1[i], 0);
        }

        for(int i = nums2.length - 1; i >= 0; i--){
            if(!nextgreater.isEmpty()) System.out.println(nextgreater.peek());
            if(nextgreater.isEmpty() && result.containsKey(nums2[i])){
                result.put(nums2[i], -1);
                nextgreater.push(nums2[i]);
            }
            else if(result.containsKey(nums2[i]) && nums2[i] < nextgreater.peek()){
                result.put(nums2[i], nextgreater.peek());
                nextgreater.push(nums2[i]);
            }
            else if(result.containsKey(nums2[i]) && nums2[i] > nextgreater.peek()){
                while(!nextgreater.isEmpty() && nums2[i] > nextgreater.peek()){
                    nextgreater.pop();
                    if(!nextgreater.isEmpty() && nums2[i] < nextgreater.peek()){
                        result.put(nums2[i], nextgreater.peek());
                        nextgreater.push(nums2[i]);
                        break;
                    }
                }
                if(nextgreater.isEmpty()){
                    result.put(nums2[i], -1);
                    nextgreater.push(nums2[i]);
                }
            }
            else{
                nextgreater.push(nums2[i]);
            }
        }
        int i = 0;
        for(int keys: result.keySet()){
            nums1[i] = result.get(nums1[i]);
            i++;
        }

        return nums1;
    }
}