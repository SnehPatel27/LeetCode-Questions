class Solution {
    public String defangIPaddr(String address) {
        StringBuilder res = new StringBuilder();
        for(char c: address.toCharArray()){
            if(c == '.'){
                res.append("[.]");
                continue;
            }
            res.append(c);
        }

        return res.toString();
    }
}