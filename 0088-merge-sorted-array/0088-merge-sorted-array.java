class Solution {

    //This is the brute force solution. 
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int j = 0;
        for(int i = m; i < m + n; i++){
            nums1[i] = nums2[j++];
        }

        Arrays.sort(nums1);
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int midpointer = m - 1;
        int nidpointer = n - 1;
        int right = m + n - 1;

        while(nidpointer >= 0){
            if(midpointer >= 0 && nums1[midpointer] > nums2[nidpointer]){
                nums1[right] = nums1[midpointer];
                midpointer--;
            }else{
                nums1[right] = nums2[nidpointer];
                nidpointer--;
            }
            right--;
        }
    }
}



    // public void merge3(int[] nums1, int m, int[] nums2, int n) {
    //     int pointer = nums1.length - 1;
    //     int k;
    //     for(int i=nums1.length-1;i>0;i--){
    //         if(n==0){
    //           k=i;
    //           break;  
    //         }
    //         if(nums1[i] == 0 && n!=0){
    //             System.out.println("inside");
    //             nums1[i] = nums2[n-1];
    //             n--;
    //         }
    //     }

    //     //while(pointer >= )

    //     if(nums1[k] > nums1[pointer]){
    //         int temp = nums1[i];
    //         nums1[i] = nums1[pointer];
    //         nums1[pointer] = temp;

    //         pointer--;
    //     }else{
    //         pointer--;
    //     }
    // }



    