
[199. Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/)

![Example Image](https://assets.leetcode.com/uploads/2021/02/14/tree.jpg)

### Approach - 1 (BFS)

- Time Complexity: O(n)
- Space Complexity: O(n)

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(queue.size() > 0) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode node = queue.remove();
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
                if(i==size-1) {
                    list.add(node.val);
                }
            }
        }
        return list;
    }
}
```


### Approach - 2 (DFS - Recursive)

- Time Complexity: O(n)
- Space Complexity: O(1) (if stack space not considered)

Dry run the code with above example picture. 

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        getRightSideView(root, 0, list);
        return list;
    }
        
    private void getRightSideView(TreeNode root, int level, List<Integer> list) {
        if(root == null) return;
        if(level == list.size()) {
            list.add(root.val);
        }
        
        if(root.right != null) {
            getRightSideView(root.right, level+1, list);
        }
        
        if(root.left != null) {
            getRightSideView(root.left, level+1, list);
        }
    }
}
```