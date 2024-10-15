class Solution {
    public long minimumSteps(String s) {
        long count = 0;
        long blackCount = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                count+=blackCount; 
            }else{
                blackCount++;
            }
        }

        return count;
    }
}