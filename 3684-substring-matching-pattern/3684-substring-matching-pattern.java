class Solution {

    //This particular function fails for the condition when the * is at the star of the string p. 
    //For eg when s = "jjv" p = "*j"
    //Because here even if the * is at the first index you tend to start the suffix search after p.length() spaces. 
    //instead you should do it after index spaces.
    public boolean hasMatchh(String s, String p) {
        int index = p.indexOf('*');

        int firstPosition = s.indexOf(p.substring(0, index));
        int secondPosition = s.indexOf(p.substring(index + 1), firstPosition + p.length());

        return (firstPosition != -1 && secondPosition != -1);
    }

    //In case of interview provide me this code
    public boolean hasMatch(String s, String p) {
        int index = p.indexOf('*');

        int firstPosition = s.indexOf(p.substring(0, index));
        int secondPosition = s.indexOf(p.substring(index + 1), firstPosition + index);

        return (firstPosition != -1 && secondPosition != -1);
    }
}