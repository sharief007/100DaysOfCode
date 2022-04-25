[146. LRU Cache](https://leetcode.com/problems/lru-cache/)

### Approach 

[Youtube Explanation]()

- Time Complexity: O(1)
- Space Complexity: O(1)

```java
class LRUCache {

    private class Pair {
        private int key, value;
        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
        
        int getKey() { return this.key; }
        int getValue() { return this.value; }
        
        void setKey(int key) { this.key = key; }
        void setValue(int value) { this.value = value; }
    }
    
    private Deque<Pair> deque;
    private final int CAPACITY;
    private int size = 0;
    private final Map<Integer, Pair> map;
    
    public LRUCache(int capacity) {
        this.CAPACITY = capacity;
        this.deque = new LinkedList<>();
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Pair pair =  map.get(key);
            
            deque.remove(pair);
            deque.addFirst(pair);
            
            return pair.getValue();
        } 
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {  // update operation
            Pair pair = map.get(key);
            
            deque.remove(pair); 
            pair.setValue(value);
            
            map.put(key, pair);
            deque.addFirst(pair);
        } else {    // create operation
            
            Pair pair = new Pair(key, value);
            
            if(size == CAPACITY) {
                // element to be removed
                Pair lastPair = deque.pollLast();
                
                // remove from hashmap
                map.remove(lastPair.getKey());
                
                size--;
            } 
            
            map.put(key, pair);
            deque.addFirst(pair);
            size++;
        }
    }
}
```