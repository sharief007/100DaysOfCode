
[236. Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)

### Approach - 1

Find path of first node from root.
Find path of second node from root.
compare both paths and find last common element. That is the answer.

[Youtube Explanation](https://www.youtube.com/watch?v=_-QHfMDde90)

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null || p == root || q == root) return root;
        
        if(p == q) return p;
        
        List<TreeNode> pathP = new LinkedList<>(), pathQ = new LinkedList<>();
        findPath(root, p, pathP);
        findPath(root, q, pathQ);
        
        int i = 0;
        for(; i < Math.min(pathP.size(), pathQ.size()); i++) {
            if(pathP.get(i) != pathQ.get(i)) break;
        }
        
        return pathP.get(i-1);
    }
    
    private boolean findPath(TreeNode root, TreeNode node, List<TreeNode> path) {
        if(root == null) return false;
        
        path.add(root);
        
        if(root == node) {
            return true;
        }
        
        boolean leftPath = findPath(root.left, node, path);
        
        // path.remove(path.size() - 1);
        
        boolean rightPath = findPath(root.right, node, path);
        if(leftPath || rightPath) return true;
        
        path.remove(path.size() - 1);
        
        return false;
        
    }
}
```

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

