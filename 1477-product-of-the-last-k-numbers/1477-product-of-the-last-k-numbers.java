class ProductOfNumbers {

    List<Integer> prefixProduct;
    

    public ProductOfNumbers() {
        prefixProduct = new ArrayList<>();
        prefixProduct.add(1);
    }
    
    public void add(int num) {
        if(num == 0){
            prefixProduct.clear();
            prefixProduct.add(1);
            return;
        }

        prefixProduct.add(prefixProduct.get(prefixProduct.size() - 1) * num);
    }
    
    public int getProduct(int k) {
        if(k >= prefixProduct.size()) return 0;
        return prefixProduct.get(prefixProduct.size() - 1) / prefixProduct.get(prefixProduct.size() - 1 - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */