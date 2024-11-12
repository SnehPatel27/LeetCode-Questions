class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder res = new StringBuilder();
        int openBrackets = 0, balance = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                openBrackets++;
                balance++;
            } 
            if(c == ')'){
                balance--;
                if(balance < 0) { 
                    balance = 0;
                    continue;
                }
            }
            res.append(c);
        }

        if(balance == 0){
            return res.toString();
        }

        StringBuilder finalR = new StringBuilder();
        System.out.println(openBrackets);
        System.out.println(balance);
        System.out.println(res.toString());

        s = res.toString();
        int openToKeep = openBrackets - balance;
        
        for(int i = 0; i < s.length(); i++){
            
            char c = s.charAt(i);

            if(c == '('){
                openToKeep--;
                if(openToKeep < 0) continue;
            }

            finalR.append(c);
        }

        return finalR.toString();
    }
}
