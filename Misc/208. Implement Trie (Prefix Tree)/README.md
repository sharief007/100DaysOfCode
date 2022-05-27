
[208. Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/)

### Approach - 1 (Use array based trie)

[Youtube Explanation](https://www.youtube.com/watch?v=dBGUmUQhjaM&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=2)

```java
class Trie {

    private Node root;
    
    public Trie() {
        this.root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        Node next = null;
        
        for(char ch: word.toCharArray()) {
            if(node.containsKey(ch)) {
                next = node.getNextNode(ch);
            } else {
                next = new Node();
                node.setNode(ch, next);
            }
            node = next;
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node = root;
        
        for(char ch: word.toCharArray()) {
            if(!node.containsKey(ch)) return false;
            
            Node next = node.getNextNode(ch);
            node = next;
        }
        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        
        for(char ch: prefix.toCharArray()) {
            if(!node.containsKey(ch)) return false;
            
            Node next = node.getNextNode(ch);
            node = next;
        }
        
        return true;
    }
    
    
    private class Node {
        
        private final Node[] map;
        private boolean end;
        
        private Node() {
            this.map = new Node[26];
            this.end = false;
        }
        
        public Node(boolean end) {
            this();
            this.end =  end;
        }
        
        public boolean isEnd() {
            return this.end;
        }
        
        public void setEnd() {
            this.end = true;
        }
        
        public boolean containsKey(char ch) {
            return map[ch - 'a'] != null;
        }
        
        public Node getNextNode(char ch) {
            return map[ch - 'a'];
        }
        
        public void setNode(char ch, Node node) {
            this.map[ch - 'a'] = node;
        }
    }
    
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
```

### Approach - 2 (Use Map based trie)

```java
class Trie {

    private Node root;
    
    public Trie() {
        this.root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        Node next = null;
        
        for(char ch: word.toCharArray()) {
            if(node.containsKey(ch)) {
                next = node.getNextNode(ch);
            } else {
                next = new Node();
                node.setNode(ch, next);
            }
            node = next;
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node = root;
        
        for(char ch: word.toCharArray()) {
            if(!node.containsKey(ch)) return false;
            
            Node next = node.getNextNode(ch);
            node = next;
        }
        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        
        for(char ch: prefix.toCharArray()) {
            if(!node.containsKey(ch)) return false;
            
            Node next = node.getNextNode(ch);
            node = next;
        }
        
        return true;
    }
    
    
    private class Node {
        
        private final Map<Character,Node> map;
        private boolean end;
        
        private Node() {
            this.map = new HashMap<>();
            this.end = false;
        }
        
        public Node(boolean end) {
            this();
            this.end =  end;
        }
        
        public boolean isEnd() {
            return this.end;
        }
        
        public void setEnd() {
            this.end = true;
        }
        
        public boolean containsKey(char ch) {
            return map.containsKey(ch);
        }
        
        public Node getNextNode(char ch) {
            return map.get(ch);
        }
        
        public void setNode(char ch, Node node) {
            this.map.put(ch, node);
        }
    }
    
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
```