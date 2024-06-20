class LRUCache {
    HashMap<Integer, Integer> map;
    LinkedHashSet<Integer> que;
    int size;
    public LRUCache(int capacity) {
        map = new HashMap(capacity);
        this.size= capacity;   
        que = new LinkedHashSet(capacity);
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            que.remove(key);
            que.add(key);
            return map.get(key);
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            que.remove(key);
        } 
        else if(que.size() == size) {
            int oldest = que.iterator().next();
            que.remove(oldest);
            map.remove(oldest);
        }
        que.add(key);
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */