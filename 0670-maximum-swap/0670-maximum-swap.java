class Solution {
    public int maximumSwap(int num) {
        char[] stringArray = Integer.toString(num).toCharArray(); 
        int[] prefixMax = new int[stringArray.length];        

        prefixMax[stringArray.length - 1] = stringArray.length - 1;
        for(int i = stringArray.length - 2; i >= 0; i--){
            if(stringArray[i] > stringArray[prefixMax[i+1]]){
                prefixMax[i] = i;
            }else{
                prefixMax[i] = prefixMax[i+1];
            }
        }

        for(int i = 0; i < stringArray.length; i++){
            if(stringArray[i] < stringArray[prefixMax[i]]){
                char temp = stringArray[i];
                stringArray[i] = stringArray[prefixMax[i]];
                stringArray[prefixMax[i]] = temp;
                return Integer.parseInt(new String(stringArray));
            }
        }

        return num;
    }
}