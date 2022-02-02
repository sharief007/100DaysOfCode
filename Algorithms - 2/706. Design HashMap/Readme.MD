
[706. Design HashMap](https://leetcode.com/problems/design-hashmap/)

[Youtube Tutorial](https://www.youtube.com/watch?v=ISir207RuKQ)

### Approach - 1

```java
class MyHashMap {
    
    private class Pair {
        int key, value;
        Pair(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }

    private LinkedList<Pair>[] map;
    private final int size = 729;
    
    public MyHashMap() {
        this.map = new LinkedList[size];   
    }
    
    public void put(int key, int value) {
        int hash = key % size;
        LinkedList<Pair> list = map[hash];
        if(Objects.nonNull(list)) {
            Pair pairToUpdate = null;
            for(Pair pair: list) {
                if(pair.key == key) {
                    pairToUpdate = pair;
                    break;
                }
            }
            if(Objects.nonNull(pairToUpdate)) {
                list.remove(pairToUpdate);
                pairToUpdate.value = value;
            } else {
                pairToUpdate = new Pair(key, value);
            }
            list.add(pairToUpdate);
        } else {
            Pair pair = new Pair(key,value);
            list = new LinkedList<>();
            list.add(pair);
            map[hash] = list;
        }
    }
    
    public int get(int key) {
        int hash = key % size;
        LinkedList<Pair> list = map[hash];
        if(Objects.isNull(list)) {
            return -1;
        }
        for(Pair pair : list) {
            if(pair.key == key) {
                return pair.value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int hash = key % size;
        LinkedList<Pair> list = map[hash];
        if(Objects.nonNull(list)) {
            Pair pairToRemove = null;
            for(Pair pair: list) {
                if(pair.key == key) {
                    pairToRemove = pair;
                }
            }
            if(Objects.nonNull(pairToRemove)) {
                list.remove(pairToRemove);
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
```