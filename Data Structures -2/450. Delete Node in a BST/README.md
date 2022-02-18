
[450. Delete Node in a BST](https://leetcode.com/problems/delete-node-in-a-bst/)

### Approach 

[Youtube Explanation](https://www.youtube.com/watch?v=kouxiP_H5WE)

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        
        if(root.val == key) {
            return delete(root);
        }
        
        // find the key node
        TreeNode temp = root;
        
        while(root != null) {
            if(root.val > key) {
                if(root.left != null && root.left.val == key) {
                    root.left = delete(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if(root.right != null && root.right.val == key) {
                    root.right = delete(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return temp;
    }
    
    
    private TreeNode delete(TreeNode node) {
        if(node.left == null) {
            return node.right;
        } else if(node.right == null) {
            return node.left;
        } else {
            TreeNode temp = node.left;
            TreeNode lastRight = findLastRightNode(node.left);
            lastRight.right = node.right;
            return temp;
        }
    }
    
    private TreeNode findLastRightNode(TreeNode root) {
        if(root.right == null) {
            return root;
        }
        return findLastRightNode(root.right);
    }
}
```