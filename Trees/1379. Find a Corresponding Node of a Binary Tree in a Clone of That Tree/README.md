
[1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree](https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/)

### Approach - 1 (BFS)

1. Traverse the original tree and find the target element.
2. Assign numbers to each node.
3. Get the node number of target element in original tree.
4. Since cloned tree is an exact copy of original tree, find the node with derived node number

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        
        long nodeNumber = getNodeNumber(original, target);
        
        return getNode(cloned, nodeNumber);
    }
    
    private TreeNode getNode(final TreeNode root, final long nodeNum) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        long count = 0;
        
        while(! queue.isEmpty()) {
            TreeNode node = queue.remove();
            
            if(count == nodeNum) {
                return node;
            }
            
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
            
            count++;
        }
        return null;
    }
    
    private long getNodeNumber(final TreeNode root, final TreeNode target) {
        Queue<TreeNode> queue = new LinkedList<>();
        
        long count = 0;        
        queue.add(root);
        
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            
            if(node == target) {
                return count;
            }
            
            if(node.left != null) {
                queue.add(node.left);
            }
            
            if(node.right != null) {
                queue.add(node.right);
            }
            
            count++;
        }
        
        return count;
    }
}
```

### Approach - 2 (DFS)

1. Traverse both tree at same time. 
2. Since both the trees have same structure, if we found the node in original tree, then curr node in cloned tree would be the answer
3. use preorder traversal

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        // if original is null, then cloned is also null 
        if (original == null) return null;
        
        // base condition
        if (original == target) {
            return cloned;
        }
        
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        TreeNode right = getTargetCopy(original.right, cloned.right, target);
        
        if(left == null) {  // not found on the left 
            return right;
        } else if(right == null) {  // not found on the right
            return left;
        } else {    // not found on both the sides
            return null;
        }
    }
}
```