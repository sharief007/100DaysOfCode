[230. Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)

### Approach -1 (Use priority queue)

Priotrity queue insertion : logN, deletion: logN

- Time Complexity: O(N* logN + K * log N)
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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        parseTree(root, queue);
        for(int i=0;i<k-1;i++) {
            System.out.printf("%s ",queue.poll());
        }
        return queue.poll();
    }
    
    private void parseTree(TreeNode root, PriorityQueue<Integer> queue) {
        if(root == null) return;
        
        queue.add(root.val);
        parseTree(root.left, queue);
        parseTree(root.right, queue);
    }
}
```


### Approach - 2

Utilise the Sorted property of BST. BST is sorted in ascending order from left to right
Use InOrder Traversal (left - root - right) to parse the tree and store in array/list.
return the element at (K-1)th index.

- Time Complexity: O(N)
- Space Complexity: O(1)

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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        parseTree(root, list);
        return list.get(k-1);   
    }
    
    private void parseTree(TreeNode root, List<Integer> list) {
        if(root == null) return;
        
        parseTree(root.left, list);
        list.add(root.val);
        parseTree(root.right, list);
    }
}
```


### Approach - 3 (Best solution)

- Time complexity: O(logn) (height of tree)
- space complexity: O(n) (auxiliary space)

```text
Also check out morris traversal for this problem https://www.youtube.com/watch?v=80Zug6D1_r4&t=3s
```

```java
public class Solution {

    int counter = 1;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        
        int temp = kthSmallest(root.left, k);        
        if (temp >= 0) return temp;
        
        if (k == counter){
            return root.val;
        }                
        counter++;
        
        return kthSmallest(root.right, k);
    }
}
```

