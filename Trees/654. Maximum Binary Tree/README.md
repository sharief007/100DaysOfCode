
[654. Maximum Binary Tree](https://leetcode.com/problems/maximum-binary-tree/)

You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively from nums using the following algorithm:

Create a root node whose value is the maximum value in nums.
Recursively build the left subtree on the subarray prefix to the left of the maximum value.
Recursively build the right subtree on the subarray suffix to the right of the maximum value.
Return the maximum binary tree built from nums.

![Image](https://assets.leetcode.com/uploads/2020/12/24/tree1.jpg)

```text
Input: nums = [3,2,1,6,0,5]
Output: [6,3,5,null,2,0,null,null,1]
Explanation: The recursive calls are as follow:
- The largest value in [3,2,1,6,0,5] is 6. Left prefix is [3,2,1] and right suffix is [0,5].
    - The largest value in [3,2,1] is 3. Left prefix is [] and right suffix is [2,1].
        - Empty array, so no child.
        - The largest value in [2,1] is 2. Left prefix is [] and right suffix is [1].
            - Empty array, so no child.
            - Only one element, so child is a node with value 1.
    - The largest value in [0,5] is 5. Left prefix is [0] and right suffix is [].
        - Only one element, so child is a node with value 0.
        - Empty array, so no child.
```

![Image](https://assets.leetcode.com/uploads/2020/12/24/tree2.jpg)

```text
Input: nums = [3,2,1]
Output: [3,null,2,null,1]
```

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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length-1);
    }
    
    private TreeNode buildTree(int[] nums, int start, int end) {
        if(start <0 || start >= nums.length || end<0 || end >= nums.length) return null;
        
        if(start > end) return null;
        
        int idx = start;    // this is important, start from starting index not from 0.
        
        for(int i=start;i<=end;i++) {
            idx = nums[i] > nums[idx] ? i : idx;
        }
        //System.out.printf("%s %s %s\n",start, end, nums[idx]);
        TreeNode root = new TreeNode(nums[idx]);
        root.left = buildTree(nums, start, idx-1);
        root.right = buildTree(nums, idx+1, end);
        
        return root;
    }
}
```