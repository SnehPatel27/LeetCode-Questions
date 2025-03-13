class UndergroundSystem {

    private Map<Integer, Pair<String, Integer>> checkInData = new HashMap<>();
    private Map<String, Pair<Double, Double>> journeyData = new HashMap<>();

    public UndergroundSystem() {
    }
    
    public void checkIn(int id, String stationName, int t) {   
        
        checkInData.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        
        Pair<String, Integer> checkInDataForId = checkInData.get(id);
        
        String startStation = checkInDataForId.getKey();
        Integer checkInTime = checkInDataForId.getValue();
        
        String routeData = stationsKey(startStation, stationName);

        Pair<Double, Double> routeStats = journeyData.getOrDefault(routeData, new Pair<>(0.0,0.0));

        double totalTripsTime = routeStats.getKey();
        double totalTrips = routeStats.getValue();

        double tripTime = t - checkInTime;
        journeyData.put(routeData, new Pair<>(totalTripsTime + tripTime, totalTrips + 1));

        

    }
    
    public double getAverageTime(String startStation, String endStation) {

        String routeKey = stationsKey(startStation, endStation);
        double totalTime = journeyData.get(routeKey).getKey();
        double totalTrips = journeyData.get(routeKey).getValue();

        return totalTime/totalTrips;
        
    }

    public String stationsKey(String startStation, String endStation){
        return startStation + "->" + endStation;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */