
[113. Path Sum II](https://leetcode.com/problems/path-sum-ii/)

### Approach - 1 (DFS)

- Time Complexity : O(n^2)
- Space Complexity: O(1) (if stack space is not considered)

(MyCode)

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new LinkedList<>();
        findPaths(root, targetSum, new ArrayList<>(), list);
        return list;
    }
    
    private void findPaths(TreeNode root, int target, List<Integer> row, List<List<Integer>> result) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            row.add(root.val);
            int sum = 0;
            for(int i : row) sum += i;
            if(sum == target) result.add(row);
            return;
        }
        
        // List<Integer> temp = new ArrayList<>(row);
        // temp.add(root.val);
        
        row.add(root.val);
        
        findPaths(root.left, target, new ArrayList<Integer>(row), result);  
        findPaths(root.right, target, new ArrayList<Integer>(row), result);
    }
}
```

(Another Code Solution)

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new LinkedList<>();
        findPaths(root, targetSum, new ArrayList<>(), list);
        return list;
    }
    
    private void findPaths(TreeNode root, int target, List<Integer> row, List<List<Integer>> result) {
        if(root == null) return;
        
        if(root.left == null && root.right == null && target-root.val == 0) {
            result.add(row);
        }
        
        row.add(root.val);
        
        findPaths(root.left, target - root.val, new ArrayList<>(row), result );
        findPaths(root.right, target - root.val, new ArrayList<>(row), result);
        
    }
}
```