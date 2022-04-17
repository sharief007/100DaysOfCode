[897. Increasing Order Search Tree](https://leetcode.com/problems/increasing-order-search-tree/)

Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.

![Image](https://assets.leetcode.com/uploads/2020/11/17/ex1.jpg)

![Image](https://assets.leetcode.com/uploads/2020/11/17/ex2.jpg)

### Approach (In Order)

- Time Complexity: O(N)
- Space Complexity: O(N)

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
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        applyDFS(root, list);
        return constructTree(list);
    }
    
    private void applyDFS(TreeNode root, List<Integer> list) {
        if(root == null) return;
        
        applyDFS(root.left, list);
        list.add(root.val);
        applyDFS(root.right, list);
    }
    
    private TreeNode constructTree(List<Integer> list) {
        if(list == null || list.size() == 0) return null;
        
        int index = 0;
        TreeNode root = new TreeNode(list.get(0));
        index++;
        TreeNode temp = root;
        for(; index< list.size(); index++) {
            temp.right = new TreeNode(list.get(index));
            temp = temp.right;
        }
        
        return root;
    }
    
}
```

### Approach - 2 (Optimal)

Construct a new tree (according to the given conditions) while traversing inorder traversal.

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
class Solution {
    
    private TreeNode head = null, parent = null;
    public TreeNode increasingBST(TreeNode root) {
        solve(root);
        return head;
    }
    
    private void solve(TreeNode root){
        if(root == null) return;
        solve(root.left);
        if(head == null) head = root;
        if(parent == null) parent = root;
        else {
            parent.right = root;
            parent = root;
            root.left = null;
        }
        solve(root.right); 
    }
}
```