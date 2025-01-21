class RandomizedSet {

    Map<Integer, Integer> dict;
    List<Integer> nums;
    Random rand = new Random();

    public RandomizedSet() {           
        dict = new HashMap<>();
        nums = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(dict.containsKey(val)) return false;

        dict.put(val, nums.size());
        nums.add(val);

        return true;
    }
    
    public boolean remove(int val) {
        if(!dict.containsKey(val)) return false;

        int currentIndex = dict.get(val);
        int lastElement = nums.get(nums.size() - 1);

        nums.set(currentIndex, lastElement);
        dict.put(lastElement, currentIndex);

        nums.remove(nums.size() - 1);
        dict.remove(val);

        return true;
    }
    
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */