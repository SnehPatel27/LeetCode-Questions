//One of the solution is to sort the shorter string s1 and then compare the window of sorted s1.length() characters in s2 and check if they are same or not. If yes return true or at the end return false. 
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        s1 = sort(s1);

        for(int i = 0; i <= s2.length() - s1.length(); i++){
            if(s1.equals(sort(s2.substring(i, i + s1.length())))){
                return true;
            }
        }
        return false;
    }

    public String sort(String s){
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}