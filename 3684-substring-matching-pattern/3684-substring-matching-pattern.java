class Solution {
    public boolean hasMatch(String s, String p) {
        int index = p.indexOf('*');

        int firstPosition = s.indexOf(p.substring(0, index));
        int secondPosition = s.indexOf(p.substring(index + 1), firstPosition + index);

        return (firstPosition != -1 && secondPosition != -1);
    }
}