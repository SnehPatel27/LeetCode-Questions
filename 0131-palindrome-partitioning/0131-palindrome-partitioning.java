class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        List<String> temp = new ArrayList<>();

        checksubstrings(result, temp, 0, s);

        return result;
    }

    public void checksubstrings(List<List<String>> result, List<String> temp, int start, String s){
        if(start >= s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int end=start+1; end<=s.length(); end++){
            if(isPalindrome(s.substring(start, end))){
                temp.add(s.substring(start, end));
                checksubstrings(result, temp, end, s);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public Boolean isPalindrome(String s){
        int left=0;
        int right=s.length() - 1;
        while(left < right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}