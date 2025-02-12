class RecentCounter {
    LinkedList<Integer> slidingWindow;
    public RecentCounter() {
        this.slidingWindow = new LinkedList<>();
    }
    
    public int ping(int t) {
        slidingWindow.add(t);

        while(slidingWindow.getFirst() < t - 3000){
            slidingWindow.removeFirst();
        }

        return slidingWindow.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */