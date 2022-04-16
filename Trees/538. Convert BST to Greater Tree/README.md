[538. Convert BST to Greater Tree](https://leetcode.com/problems/convert-bst-to-greater-tree/)

Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.

As a reminder, a binary search tree is a tree that satisfies these constraints:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

![Image](https://assets.leetcode.com/uploads/2019/05/02/tree.png)


### Approach - 1 (PreOrder Traversal)

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
    
    private int idx = 0;
    
    public TreeNode convertBST(TreeNode root) {
        TreeNode head = root;
        ArrayList<Integer> array = new ArrayList<>();
        
        applyDFSRead(root, array);
        
        int sum = 0;
        for(int i=array.size() - 1; i>=0; i--) {
            sum += array.get(i);
            array.set(i, sum);
        }
        
        // System.out.println(array);
        root = head;
        applyDFSWrite(root, array);
        
        return head;
    }
    
    private void applyDFSRead(TreeNode root, ArrayList<Integer> list) {
        if(root == null) return;
        
        applyDFSRead(root.left, list);
        list.add(root.val);
        applyDFSRead(root.right, list);
    }
    
    private void applyDFSWrite(TreeNode root, ArrayList<Integer> list) {
        if(root == null) return;
        
        applyDFSWrite(root.left, list);
        root.val = list.get(idx);
        idx++;
        // System.out.println(idx);
        applyDFSWrite(root.right, list);
    }
}
```

### Approach - 2 (Reverse Preorder Traversal)

- Time Complexity: O(N)
- Space Complexity: (1) ~ Ignoring auxiliary stack space

```java
class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null){
            return root;
        }
        reverseInorder(root);
        return root;
    }
    private void reverseInorder(TreeNode root){
        if(root==null){
            return;
        }
        reverseInorder(root.right);
        root.val = root.val + sum;
        sum = root.val;
        reverseInorder(root.left);
        return;
    }
}
```