[116. Populating Next Right Pointers in Each Node](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)

### Approach (BFS)

- Time Complexity: O(N)
- Space Complexity: O(N)

```java

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(queue.size() > 0) {
            int size = queue.size();
            
            for(int i=0;i<size;i++) {
                Node node = queue.remove();
                
                if(i == size -1) {
                    node.next = null;
                } else {
                    node.next = queue.peek();
                }
                
                if(node.left != null) {
                    queue.add(node.left);
                }
                
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}
```

### Approach (Optimal DFS)

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    public Node connect(Node root) {
        connectInternalNodes(root);
        return root;
    }
    
    private void connectInternalNodes(Node root) {
        if(root == null ) return;
        if(root.left !=null && root.right != null) {
            root.left.next = root.right;
            connectRightToLeft(root.left,root.right);
            connectInternalNodes(root.left);
            connectInternalNodes(root.right);
        }
    }
    
    private void connectRightToLeft(Node left,Node right) {
        if(left == null) return;
        if(left.right != null) {
            left.right.next = right.left;
            connectRightToLeft(left.right,right.left);
        }
    }
```