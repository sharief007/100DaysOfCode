[987. Vertical Order Traversal of a Binary Tree]()


Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.

![Example](https://assets.leetcode.com/uploads/2021/01/29/vtree1.jpg)

```text
Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.
```

![Example](https://assets.leetcode.com/uploads/2021/01/29/vtree2.jpg)

```text
Input: root = [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
Column -2: Only node 4 is in this column.
Column -1: Only node 2 is in this column.
Column 0: Nodes 1, 5, and 6 are in this column.
          1 is at the top, so it comes first.
          5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
Column 1: Only node 3 is in this column.
Column 2: Only node 7 is in this column.
```
![Example](https://assets.leetcode.com/uploads/2021/01/29/vtree3.jpg)

```text
Input: root = [1,2,3,4,6,5,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
This case is the exact same as example 2, but with nodes 5 and 6 swapped.
Note that the solution remains the same since 5 and 6 are in the same location and should be ordered by their values.
```

### Approach (Use BFS)

Not as easy as it looks

- Time Complexity: O(N * Nlog N)
- Space Complexity: O(N)

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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Map<Integer, Map<Integer,List<Integer>>> map = new TreeMap<>();
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        
        int rowLevel = 0;
        
        while(!queue.isEmpty()) {
            rowLevel++;
            int size = queue.size();
            
            for(int i=0;i<size;i++) {
                Pair pair = queue.poll();
                TreeNode node = (TreeNode) pair.getKey();

                if(node != null) {
                    int level = (Integer) pair.getValue();

                    Map<Integer,List<Integer>> rowMap = map.getOrDefault(level, new TreeMap<>());
                    List<Integer> list = rowMap.getOrDefault(rowLevel, new LinkedList<>());
                    list.add(node.val);
                    rowMap.put(rowLevel, list);
                    map.put(level, rowMap);

                    queue.add(new Pair(node.left, level-1));
                    queue.add(new Pair(node.right, level+1));
                }
            }
        }
        
        for(int key : map.keySet()) {
            Map<Integer,List<Integer>> rowWiseMap = map.get(key);
            List<Integer> ans = new LinkedList<>();
            for(int rowKey: rowWiseMap.keySet()) {
                List<Integer> list = rowWiseMap.get(rowKey);
                Collections.sort(list);
                ans.addAll(list);
            }
            result.add(ans);
        }
        
        return result;
    }
}
```