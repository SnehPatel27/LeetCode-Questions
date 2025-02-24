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