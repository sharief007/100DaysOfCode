[124. Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/)

### Approach (Stolen)

[Youtube Explanation](https://www.youtube.com/watch?v=WszrfSwMz58&t=229s)

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    private int maxSum;
    
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        int pathSum = maximumPathSum(root);
        maxSum = Math.max(maxSum, pathSum);
        return maxSum;
    }
    
    private int maximumPathSum(TreeNode root) {
        if(root == null) return 0;
        
        int leftPathSum = maximumPathSum(root.left);
        int rightPathSum = maximumPathSum(root.right);
        
        leftPathSum = leftPathSum < 0 ? 0 : leftPathSum;
        rightPathSum = rightPathSum < 0 ? 0 : rightPathSum;
        
        int pathSum = root.val + leftPathSum + rightPathSum;
        
        maxSum = Math.max(pathSum, maxSum);
        // System.out.printf("%s %s  \n", leftPathSum, rightPathSum);
        return root.val + Math.max(leftPathSum, rightPathSum);
    }
}
```