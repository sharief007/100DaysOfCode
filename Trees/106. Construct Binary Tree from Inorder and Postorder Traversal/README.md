[106. Construct Binary Tree from Inorder and Postorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

### Approach 

[Youtube Explanation](https://www.youtube.com/watch?v=s5XRtcud35E)

- Time Complexity: O(n)
- Space Complexity: O(n)

```java
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0; i<n; i++) {
            map.put(inorder[i], i);
        }
        
        return constructTree(inorder, postorder, n-1, 0, n-1, map);
    }
    
    private TreeNode constructTree(int[] inorder, int[] postorder, int post, int start, int end, Map<Integer,Integer> map) {
        if(post < 0 || start > end) {
            return null;
        }
        
        while( map.get(postorder[post]) < start || map.get(postorder[post]) > end ) {
            post--;
        }
        
        int rootValue = postorder[post];
        int index = map.get(rootValue);
        
        TreeNode root = new TreeNode(rootValue);
        
        root.left = constructTree(inorder, postorder, post - 1, start, index-1, map);
        root.right = constructTree(inorder, postorder, post -1, index+1, end, map);
        
        return root;
    }
}
```