class BrowserHistory {
    String currentUrl;
    List<String> backwardHistory;
    List<String> forwardHistory;

    public BrowserHistory(String homepage) {
        this.currentUrl = homepage;
        this.backwardHistory = new ArrayList<>();
        this.forwardHistory = new ArrayList<>();
    }
    
    public void visit(String url) {
        backwardHistory.add(currentUrl);
        currentUrl = url;
        forwardHistory = new ArrayList<>();
    }
    
    public String back(int steps) {
        
        while(steps > 0 && backwardHistory.size() > 0){
            forwardHistory.add(currentUrl);
            currentUrl = backwardHistory.remove(backwardHistory.size() - 1);
            steps--;
        }
        
        return currentUrl;
    }
    
    public String forward(int steps) {
        
        while(steps > 0 && forwardHistory.size() > 0){
            backwardHistory.add(currentUrl);
            currentUrl = forwardHistory.remove(forwardHistory.size() - 1);
            steps--;
        }

        return currentUrl;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */