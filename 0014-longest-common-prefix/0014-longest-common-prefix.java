class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if(strs == null || strs.length == 0){
            return "";
        }

        String prefix = strs[0];

        for(int i = 1; i < strs.length; i++){
            while(!strs[i].startsWith(prefix)){
                prefix = strs[0].substring(0, prefix.length() - 1);
                if(prefix == "") return "";
            }
        }

        return prefix;
    }
}