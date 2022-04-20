
[1382. Balance a Binary Search Tree](https://leetcode.com/problems/balance-a-binary-search-tree/)

Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.

A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.

![Example image](https://assets.leetcode.com/uploads/2021/08/10/balance1-tree.jpg)

### Approach - 1

- Convert the tree to a sorted array using an in-order traversal.
- Construct a new balanced tree from the sorted array recursively.

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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list);
        root = balanceTree(list, 0, list.size() -1);
        return root;
    }
    
    private TreeNode balanceTree(List<Integer> list, int start, int end) {
        if(start > end) return null;
        
        int mid = start + (end -start)/2;
        
        int val = list.get(mid);
        TreeNode node = new TreeNode(val);
        
        node.left = balanceTree(list, start, mid -1);
        node.right =  balanceTree(list, mid+1, end);
        
        return node;
    }
    
    private void inOrderTraversal(TreeNode root, List<Integer> list) {
        if(root == null) return;
        
        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);
    }
    
}
```