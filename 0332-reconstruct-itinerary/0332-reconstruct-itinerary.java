class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        // Create an adjacency list where each source airport points to a priority queue of destinations
        // Time: O(E log Kavg) → building adjacency list
        // (Each ticket insertion into PriorityQueue is O(log K), where K is number of destinations from a node)
        // In worst case (large K), it becomes O(E log E)
        HashMap<String, PriorityQueue<String>> adjList = new HashMap<>();
        
        // Build the graph from the list of tickets
        for (List<String> ticket : tickets) {
            String source = ticket.get(0);
            String destination = ticket.get(1);
            
            // Initialize priority queue if not already present for the source
            adjList.putIfAbsent(source, new PriorityQueue<>());
            
            // Add destination to the source's priority queue
            adjList.get(source).offer(destination);
        }

        // List to store the final itinerary
        List<String> itinerary = new ArrayList<>();

        // Start DFS traversal from "JFK"
        // Time: O(E log K) → DFS traversal visiting each edge once and polling from PQ
        calculateItinerary(itinerary, tickets, adjList, "JFK");

        // Since nodes were added after exploration (post-order), reverse to get correct order
        // Time: O(E) → final reversal
        Collections.reverse(itinerary);
        return itinerary;
    }

    // Helper function to perform DFS traversal
    public void calculateItinerary(List<String> itinerary, List<List<String>> tickets, HashMap<String, PriorityQueue<String>> adjList, String source) {

        // Get the destinations reachable from current source
        PriorityQueue<String> destinations = adjList.get(source);

        // Important:
        // destinations can be null if source airport has no outgoing flights
        // or it can become empty after consuming all flights
        while (destinations != null && !destinations.isEmpty()) {
            // Poll the next smallest destination from the priority queue
            String destination = destinations.poll();
            // Recursive DFS call to process the next destination
            calculateItinerary(itinerary, tickets, adjList, destination);
        }

        // Once all flights from current source are used, add source to itinerary
        // (This ensures correct order after full exploration — Hierholzer's algorithm)
        itinerary.add(source);
        
        return;
    }
}

/* 
Time Complexity: O(E log E)
E = number of tickets
Priority queue operations + DFS traversal dominate
Space Complexity: O(E): Adjacency list + call stack + result path storage
*/
