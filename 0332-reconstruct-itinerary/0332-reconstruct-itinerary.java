class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> adjList = new HashMap<>();
        
        for(List<String> ticket: tickets){
            
            String source = ticket.get(0);
            String destination = ticket.get(1);
            
            adjList.putIfAbsent(source, new PriorityQueue<>());
            adjList.get(source).offer(destination);
        }

        List<String> itinerary = new ArrayList<>();

        calculateItinerary(itinerary, tickets, adjList, "JFK");

        Collections.reverse(itinerary);
        return itinerary;
    }

    public void calculateItinerary(List<String> itinerary, List<List<String>> tickets, HashMap<String, PriorityQueue<String>> adjList, String source){

        PriorityQueue<String> destinations = adjList.get(source);

        //Lets consider the first Example where SJC has no destinations.
        //In that case destinations would be null.
        //Also there would be cases when destinations after removal of destination becomes empty but not null.
        //So we need both the conditions one to check if its not null and the second to check if its not empty. 
        while(destinations != null && !destinations.isEmpty()){
            String destination = destinations.poll();
            calculateItinerary(itinerary, tickets, adjList, destination);
        }
        itinerary.add(source);
        return;
    }
}