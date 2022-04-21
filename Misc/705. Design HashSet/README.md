[705. Design HashSet](https://leetcode.com/problems/design-hashset/)

### Approach

```java
class MyHashSet {

    private final int SIZE = 997;
    private final List<Integer>[] buckets;
    
    public MyHashSet() {
        buckets = new LinkedList[SIZE];
    }
    
    public void add(int key) {
        int hash = key % SIZE;
        List<Integer> values = buckets[hash];
        if(values != null) {
            for(int num : values) {
                if(num == key) {
                    return;
                }
            }
            values.add(key);
        } else {
            values = new LinkedList<>();
            values.add(key);
        }
        buckets[hash] = values;
    }
    
    public void remove(int key) {
        int hash = key % SIZE;
        List<Integer> values = buckets[hash];
        if(values != null) {
            values.remove(Integer.valueOf(key));
        }
    }
    
    public boolean contains(int key) {
        int hash = key % SIZE;
        List<Integer> values = buckets[hash];
        if(values != null) {
            return values.indexOf(key) > -1;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
```