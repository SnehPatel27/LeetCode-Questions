class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer = 0;
        if(n == 0){
            return;
        }
        for(int i=0;i<nums1.length;i++){
            if(nums1[i] == 0 && pointer<n){
                System.out.println("comparing "+nums1[i]+ " and "+nums2[pointer]);
                nums1[i] = nums2[pointer];
                pointer++;
            }
        }
        Arrays.sort(nums1);
    }
}