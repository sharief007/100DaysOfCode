[100. Same Tree](https://leetcode.com/problems/same-tree/)

### Approach (Bruteforce)

Apply any traversal on both the trees and comapre their results.

[Youtube Explanation](https://www.youtube.com/watch?v=BhuvF_-PWS0)

### Approach (mine) Optimal

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        
        if(p != null && q == null) return false;
        if(p == null && q != null) return false;
        
        if(p.val != q.val) return false;
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
```