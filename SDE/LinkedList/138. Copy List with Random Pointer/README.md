[138. Copy List with Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer/)

### Approach - 1 (Using Hashmap)

[Watch this amazing youtube explanation](https://www.youtube.com/watch?v=5Y2EiZST97Y)

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        
        Node curr = head;
        
        while(curr != null) {
            Node newNode = new Node(curr.val);
            map.put(curr, newNode);
            
            curr = curr.next;
        }
        
        curr = head;
        while(curr != null) {
            Node newNode = map.get(curr);
            newNode.random = map.getOrDefault(curr.random, null);
            newNode.next = map.getOrDefault(curr.next, null);
            
            curr = curr.next;
        }
        
        return map.get(head);
    }
}
```

### Approach - 2 (Optimal)

[Youtube Explanation - TUF](https://www.youtube.com/watch?v=VNf6VynfpdM)

```java
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        
        Node temp = head;
        // copying the nodes
        while(temp != null){
            Node curr = temp.next;
            temp.next = new Node(temp.val);
            temp.next.next = curr;
            temp = curr;
        }
        temp = head;
        // setting the random pointers
        while(temp != null){
            if(temp.next != null){
                temp.next.random = (temp.random != null)?
                    temp.random.next : null;
            }
            temp = temp.next.next;
        }
        
        Node orig = head , copy = head.next;
        Node curr = copy;
        // separating orignal and copied list
        while(orig != null){
            orig.next = orig.next.next;
            copy.next = (copy.next != null) ? 
                copy.next.next : copy.next;
            orig = orig.next;
            copy = copy.next;
        }
        return curr;
     }
}
```