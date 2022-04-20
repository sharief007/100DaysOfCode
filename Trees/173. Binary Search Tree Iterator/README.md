
[173. Binary Search Tree Iterator](https://leetcode.com/problems/binary-search-tree-iterator/)

### Approach - 1

- Time complexity: O(n)
- space complexity: O(n)

```java

class BSTIterator {
    public Queue<TreeNode> q=new LinkedList<>();
    public BSTIterator(TreeNode root) {
        inOrder(root);
    }
    public void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        q.add(root);
        inOrder(root.right);
    }
    
    public int next() {
        return q.poll().val;
    }
    
    public boolean hasNext() {
        return !q.isEmpty();
    }
}

```

### Approach - 2

- Time complexity: O(N)
- Space complexity: O(logN) (height of tree)

[Youtube Explanation](https://www.youtube.com/watch?v=D2jMcmxU4bs)

```java

class BSTIterator {

    private TreeNode node = null;
    
    private Stack<TreeNode> stack = new Stack<>();
    
    public BSTIterator(TreeNode root) {
        node = root;
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode top = stack.pop();
        if(top.right != null) {
            TreeNode root = top.right;
            
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

        }
        return top.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

```