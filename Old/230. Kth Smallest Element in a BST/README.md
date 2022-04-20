
[230. Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)

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
    
    private int counter = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        if(Objects.isNull(root)) return Integer.MIN_VALUE;
        
        int val = kthSmallest(root.left, k);
        
        if(val >= 0) return val;
        
        counter++;
        
        if(counter == k) return root.val;
        
        return kthSmallest(root.right, k);
    }
}
```