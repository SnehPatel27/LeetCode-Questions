//Sorting the word would make them mobile, moneypot, monitor, mouse, mousepad.
//Intitally lets assume our leftPointer would be pointing towards mobile and rightPointer would be pointing towards mousepad. 
//First we start with each character in the search word initally it would be 'm'
//word pointing at leftPointer(mobile) matches with m.
//word pointing at rightPointer(mousepad) matches with m. 
//We take the min(rightPointer - leftPointer + 1 and 3) and print 3 words. 

//Next word pointing at leftPointer(mobile) matches with mo same goes for RightPointer.
//Top 3 words are added to the finalList. 

//Next character is u. 
//We shift LeftPointer till we get a word that matches with u. so we end with with mouse. leftPointer goes to 3. 
//RightPointer does not shift. 

//We continue this
//In short leftPointer and rightPointer are the bounds in which we get our words that matches the searchWord. 

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        int leftPointer = 0;
        int rightPointer = products.length - 1;
        List<List<String>> result = new ArrayList<>();

        for(int i = 0; i < searchWord.length(); i++){
            char c = searchWord.charAt(i);

            while(leftPointer <= rightPointer && (products[leftPointer].length() <= i || products[leftPointer].charAt(i) != c)){
                leftPointer++;
            }
            while(leftPointer <= rightPointer && (products[rightPointer].length() <= i || products[rightPointer].charAt(i) != c)){
                rightPointer--;
            }

            List<String> temp = new ArrayList<>();
            for(int j = 0; j < Math.min(3, rightPointer - leftPointer + 1); j++){
                temp.add(products[j + leftPointer]);
            }

            result.add(temp);
        }

        return result;
    }
}