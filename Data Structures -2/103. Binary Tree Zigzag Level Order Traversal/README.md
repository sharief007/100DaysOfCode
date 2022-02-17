
[103. Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)

### Approach (Brain F*ck)

1. Apply BFS, use queue not deque. (parse the tree using regular BFS algorithm, no chnages in parsing)
2. While storing the result, use a flag variable to determine the direction and use linkedlist to addFirst or addLast depending on flag variable.

little change in result list but no change in BFS.

[Youtube Explanation](https://www.youtube.com/watch?v=3OXWEdlIGl4)

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> list = new LinkedList();
        
        if(root == null) return list;
        
        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = false;
        
        queue.add(root);
        
        while(queue.size() > 0) {
            int size = queue.size();
            LinkedList<Integer> row = new LinkedList<>();
            for(int i=0;i<size;i++) {
                TreeNode node = queue.remove();
                
                if(flag) {
                    row.addFirst(node.val);
                } else {
                    row.addLast(node.val);
                }
                
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            flag = !flag;
            list.add(row);
        }
        return list;        
    }
}
```
