[297. Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)


### Approach 

[Youtube Explanation](https://www.youtube.com/watch?v=-YbXySKJsX8)

Serialization 
- Time Complexity :O(N)
- Space Complexity: O(N)

Deserialization
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        while(queue.size() > 0) {
            int size = queue.size();
            
            for(int i=0;i<size;i++) {
                TreeNode node = queue.remove();
                
                if(Objects.isNull(node)) {
                    builder.append("#,");
                } else {
                    builder.append(String.format("%s,",node.val));
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }
        return builder.toString();        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<TreeNode> queue = new LinkedList<>();
        String[] elems = data.split(",");
        System.out.println(Arrays.toString(elems));
        if(elems.length> 0 && !elems[0].equals("#")) {
            int idx = 1;
            TreeNode root = new TreeNode(Integer.parseInt(elems[0]));
            queue.add(root);
            while (queue.size() > 0) {
                TreeNode node = queue.remove();
                
                if(elems[idx].equals("#")) {
                    node.left = null;
                } else {
                    TreeNode newNode = new TreeNode(Integer.parseInt(elems[idx]));
                    node.left = newNode;
                    queue.add(newNode);
                }
                idx++;
                
                if(elems[idx].equals("#")) {
                    node.right = null;
                } else {
                    TreeNode newNode = new TreeNode(Integer.parseInt(elems[idx]));
                    node.right = newNode;
                    queue.add(newNode);
                }
                idx++;
                
            }
            return root;
        }
        return null;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
```