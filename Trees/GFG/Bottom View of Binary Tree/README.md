[Bottom View of Binary Tree](https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1#)

[Youtube Explanation](https://www.youtube.com/watch?v=0FtVY6I4pB8)

### Approach (BFS)

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer,Integer> map = new TreeMap<>();
        
        queue.offer(new Pair(root, 0));
        
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            Node node = pair.root;
            if(node != null) {
                map.put(pair.level, node.data);
                queue.add(new Pair(node.left, pair.level-1));
                queue.add(new Pair(node.right, pair.level+1));
            }
        }
        
        return new ArrayList<Integer>(map.values());
    }
    
    private static class Pair {
        Node root;
        int level;
        Pair(Node root, int level) {
            this.root = root;
            this.level = level;
        }
    }
}
```