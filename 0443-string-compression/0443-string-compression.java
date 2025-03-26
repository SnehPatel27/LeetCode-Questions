class Solution {
    public int compress(char[] chars) {
        int i = 0;
        int readIndex = 0;
        while(readIndex < chars.length){
            int characterCount = 1;
            char currentChar = chars[readIndex];
            while(readIndex + 1 < chars.length && chars[readIndex + 1] == currentChar){
                readIndex++;
                characterCount++;
            }

            chars[i++] =  currentChar;
            if(characterCount > 1){
                String tempString = Integer.toString(characterCount);
                for(int k = 0; k < tempString.length(); k++){
                    chars[i++] = tempString.charAt(k);
                }
            }

            readIndex++;
        }
        return i;
    }
}