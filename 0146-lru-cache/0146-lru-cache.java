class LRUCache {
    class Node{
        int key;
        int val;
        Node previous;
        Node next;

        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    int capacity;
    HashMap<Integer, Node> map = new HashMap<>();


    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.previous = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node temp = map.get(key);   
            int ans = temp.val;

            deleteNode(temp);
            insertAfterHead(temp);

            return ans;    
        }

        return -1;
    }
    
    public void put(int key, int value) {

        if(map.containsKey(key)){

            Node temp = map.get(key);
            map.remove(key);
            deleteNode(temp);

        }

        if(map.size() == capacity){

            map.remove(tail.previous.key);
            deleteNode(tail.previous);

        }

        insertAfterHead(new Node(key, value));
        map.put(key, head.next);
    }

    public void insertAfterHead(Node node){
        
        Node currentHead = head.next;
        
        node.next = currentHead;
        node.previous = head;

        head.next = node;
        currentHead.previous = node;

    }

    public void deleteNode(Node node){

        Node tempNode = node.previous;
        Node nextNode = node.next;
        
        tempNode.next = nextNode;
        nextNode.previous = tempNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */