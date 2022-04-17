
[700. Search in a Binary Search Tree](https://leetcode.com/problems/search-in-a-binary-search-tree/)

### Approach (BFS)

- Time Complexity: O(log N)
- Space Complexity: O(log N)

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
    public TreeNode searchBST(TreeNode root, int val) {
        
        if(root == null || root.val == val) return root;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(queue.size() > 0) {
            TreeNode node = queue.poll();
            
            if(Objects.nonNull(node)) {
                if(node.val > val) {
                    queue.add(node.left);
                } else if (node.val < val) {
                    queue.add(node.right);
                } else {
                    return node;
                }
            }
        }
        return null;
    }
}
```

### Approach (DFS)

- Time Complexity: O(Log N)
- Space Complexity: O(log N)

```java
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val) return root;// Base Cases: root is null or val is present at root
		if(root.val > val) return searchBST(root.left, val); // Value is greater than root's val then search in right side of the root
		return searchBST(root.right, val);  //Value is smaller than root's val then search in left side of the root
    }
}
```

### Approach (Iterative)

- Time Complexity: O(Log N)
- Space COmplexity: O(1)

```java
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
   
        if(root == null)return null;//Base Condition(If tree is empty )
        while (root != null && root.val !=val){//Tree is not empty and root value is not equals to val
            root = val <root.val?root.left :root.right;//terminatory condition if val smaller than root value then search in left side else on right side
        }
        return root;  
    }
}
```