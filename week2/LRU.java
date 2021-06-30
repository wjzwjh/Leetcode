class LRUCache {
    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            //remove Node
            this.removeNode(node);
            //move node to head
            this.moveNodeToHead(node);
            return node.value;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
             //remove Node
            this.removeNode(node);
            //move node to head
            this.moveNodeToHead(node);
            map.put(key, node);  
        }else{      
            if(map.size() >= this.capacity){
                Node lastNode = tail.prev;
                this.removeNode(lastNode);
                map.remove(lastNode.key);
            }
            
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            this.moveNodeToHead(newNode);
            map.put(key, newNode);
        }
        
       
    }
    
    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void moveNodeToHead(Node node) {
        Node temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
        
    }
    
    private class Node {
        public int key;
        public int value;
        public Node prev;
        public Node next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
