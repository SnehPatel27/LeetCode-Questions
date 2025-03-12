class Solution {
    public int punishmentNumber(int n) {
        int punishmentNmber = 0;
        for(int i = 1; i <= n; i++){
            int squaredNumber = i * i;
            if (isSatisfied(Integer.toString(squaredNumber), i)){
                punishmentNmber += squaredNumber;
            }
        }

        return punishmentNmber;
    }

    public boolean isSatisfied(String currentString, int target){

        if(currentString.length() == 0 && target == 0){
            return true;
        }

        if(target < 0){
            return false;
        }

        for(int index = 0; index < currentString.length(); index++){
            String leftSubstring = currentString.substring(0, index + 1);
            String rightSubstring = currentString.substring(index + 1);
            int leftNum = target - Integer.parseInt(leftSubstring);
            if(isSatisfied(rightSubstring, leftNum)){
                return true;
            }
        }

        return false;
    }
}