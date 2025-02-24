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

/* When we increment a key, we first check if it exists in the hashmap. If the key is new, we look at the node after the dummy head. If that node does not have a frequency of 1, we create a new node for frequency 1. We add the key to this node and update the hashmap. If the key already exists, we find its current frequency node and check the next node, which shows the next higher frequency. If that next node is the tail or does not have the expected frequency, we create a new node with the increased frequency. We then move the key to the right node, remove it from the old node, and delete the old node if it becomes empty.

When we decrement a key, we first check if it is in the hashmap. If it is, we remove it from its current node. If the key’s frequency is greater than one, we check the previous node. If needed, we create a new node for the decreased frequency and add the key to the appropriate previous node, updating the hashmap. If the frequency is one, we remove the key from the hashmap completely. */

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