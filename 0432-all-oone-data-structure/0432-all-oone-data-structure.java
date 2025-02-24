//This is not the optimal solution. 
// class AllOne {

//     HashMap<String, Integer> freq;

//     public AllOne() {
//         freq = new HashMap<>();
//     }
    
//     public void inc(String key) {
//         freq.put(key, freq.getOrDefault(key, 0) + 1);
//         return;
//     }
    
//     public void dec(String key) {
//         freq.put(key, freq.get(key) - 1);
//         if(freq.get(key) == 0){
//             freq.remove(key);
//         }
//     }
    
//     public String getMaxKey() {
//         int max = Integer.MIN_VALUE;
//         String res = "";
//         for(String i: freq.keySet()){
//             if(freq.get(i) > max){
//                 res = i;
//                 max = freq.get(i);
//             }
//         }

//         return res;
//     }
    
//     public String getMinKey() {
//         int min = Integer.MAX_VALUE;
//         String res = "";
//         for(String i: freq.keySet()){
//             if(freq.get(i) < min){
//                 res = i;
//                 min = freq.get(i);
//             }
//         }

//         return res;
//     }
// }

class Node{
    int freq;
    Node next;
    Node prev;
    HashSet<String> keys = new HashSet<>();

    Node(int freq){
        this.freq = freq;
    }
}

class AllOne {

    Node head;
    Node tail;
    HashMap<String, Node> map = new HashMap<>();

    public AllOne() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }
    
    public void inc(String key) {
        
        if(map.containsKey(key)){
            Node node = map.get(key);
            int freq = node.freq;
            node.keys.remove(key);

            Node nextNode = node.next;
            if(nextNode == tail || nextNode.freq != freq + 1){
                Node newNode = new Node(freq + 1);
                newNode.keys.add(key);
                newNode.prev = node;
                newNode.next = nextNode;

                nextNode.prev = newNode;
                node.next = newNode;

                map.put(key, newNode);
            } else {
                nextNode.keys.add(key);
                map.put(key, nextNode);
            }

            if(node.keys.isEmpty()){
                removeNode(node);
            }
        } else {
            Node firstNode = head.next;
            if(firstNode == tail || firstNode.freq > 1){
                Node newNode = new Node(1);
                newNode.keys.add(key);
                newNode.next = firstNode;
                newNode.prev = head;

                firstNode.prev = newNode;
                head.next = newNode;

                map.put(key, newNode);
            } else {
                firstNode.keys.add(key);
                map.put(key, firstNode);
            }
        }
    }
    
    public void dec(String key) {

        if(!map.containsKey(key))
            return;
        
        Node node = map.get(key);
        int freq = node.freq;
        node.keys.remove(key);

        if(freq == 1){
            map.remove(key);
        } else {
            Node prevNode = node.prev;
            if(prevNode == head || prevNode.freq != freq - 1){
            Node newNode = new Node(freq - 1);
            newNode.keys.add(key);

            newNode.next = node;
            newNode.prev = prevNode;

            prevNode.next = newNode;
            node.prev = newNode;

            map.put(key, newNode);
        } else {
                prevNode.keys.add(key);
                map.put(key, prevNode);
            }
        }

        if(node.keys.isEmpty()){
            removeNode(node);
        }
    }
    
    public String getMaxKey() {
        if(tail.prev == head){
            return "";
        } 
        return tail.prev.keys.iterator().next();
    }
    
    public String getMinKey() {
        if(head.next == tail){
            return "";
        } 
        return head.next.keys.iterator().next();
    }

    public void removeNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */