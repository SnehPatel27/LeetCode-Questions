class Solution {
    public int maxArea(int[] height) {
        // int leftp = 0;
        // int area = 0;
        // int rightp = height.length-1;
        // while(leftp < rightp){
        //     int breadth = rightp - leftp;
        //     int length = Math.min(height[leftp], height[rightp]);
        //     area = Math.max(area, length * breadth);

        //     if(height[leftp] > height[rightp]){
        //         rightp--;
        //     }else{
        //         leftp++;
        //     }
        // }
        // return area;

        int n = height.length;
        int left = 0;
        int right = n - 1;
        int ans = Integer.MIN_VALUE;
        while(left<right){
            int distance = right - left;
            ans = Math.max(ans, distance * (Math.min(height[left], height[right])));

            if(height[left] <= height[right]){
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }
}