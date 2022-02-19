
[236. Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)

### Approach - 1

Find path of first node from root.
Find path of second node from root.
compare both paths and find last common element. That is the answer.

[Youtube Explanation](https://www.youtube.com/watch?v=_-QHfMDde90)

- Time Complexity: O(N)
- Space Complexity: O(N)

### Approach - 2

[Youtube Explanation](https://www.youtube.com/watch?v=_-QHfMDde90)

- Time Complexity: O(N)
- Space Complexity: O(N) (Auxiliary space)

```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        } else {
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            
            if(left == null) {
                return right;
            } else if(right == null) {
                return left;
            } else {
                return root;
            }
        }
    }
}
```

