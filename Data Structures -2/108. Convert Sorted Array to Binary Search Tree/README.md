
[108. Convert Sorted Array to Binary Search Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)

Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

![Example Picture](https://assets.leetcode.com/uploads/2021/02/18/btree1.jpg)

### Approach

Since array is sorted, apply Binary search and fill left and right nodes accordingly.

- Time Complexity : O(N)
- Space Complexity: O(n) (stack space)


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
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length-1);        
    }
    
    private TreeNode buildTree(int[] nums, int start, int end) {
        if(start > end) return null;
        
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        
        node.left = buildTree(nums, start, mid-1);
        node.right = buildTree(nums, mid+1, end);
        
        return node;
    }
}
```