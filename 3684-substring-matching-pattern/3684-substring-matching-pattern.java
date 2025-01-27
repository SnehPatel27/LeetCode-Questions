class Solution {

    //This particular function fails for the condition when the * is at the star of the string p. 
    //For eg when s = "jjv" p = "*j"
    public boolean hasMatch(String s, String p) {
        int index = p.indexOf('*');

        int firstPosition = s.indexOf(p.substring(0, index));
        int secondPosition = s.indexOf(p.substring(index + 1), firstPosition + p.substring(0, index).length());

        return (firstPosition != -1 && secondPosition != -1);
    }
}