[Left View of Binary Tree](https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1#)

### Approach (In order traversal)

- Time Complexity: O(N)
- Space Complexity: O(diameter of tree)

```java
//User function Template for Java

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> view = new ArrayList<>();
        
        if(root == null) return view;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size; i++) {
                Node node = queue.remove();
                
                if(i==0) {
                    view.add(node.data);
                }
                
                if(node.left != null) {
                    queue.add(node.left);
                }
                
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return view;
    }
}
```

### Approach (DFS)

- Time Complexity: O(N)
- Space Complexity: O(1) // is auxiliary stack space is not ignored, then O(Height of tree)

```java
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> view = new ArrayList<>();
        leftViewTraversal(root, view, 0);
        return view;
    }
    
    private void leftViewTraversal(Node root, ArrayList<Integer> view, int level) {
        if(root == null) return;
        
        if(level == view.size()) {
            view.add(root.data);
        }
        
        leftViewTraversal(root.left, view, level+1);
        
        leftViewTraversal(root.right, view, level+1);   
    }    
}
```