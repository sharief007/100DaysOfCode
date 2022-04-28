[Mirror Tree](https://practice.geeksforgeeks.org/problems/mirror-tree/1)

![Example](https://contribute.geeksforgeeks.org/wp-content/uploads/mirrortrees.jpg)

### Approach

```java
class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        // Your code here
        if(node == null) return;
        
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        
        mirror(node.left);
        mirror(node.right);
    }
}
```