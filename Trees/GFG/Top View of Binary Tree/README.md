[Top View of Binary Tree](https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1#)

[Youtube Explanation](https://www.youtube.com/watch?v=Et9OCDNvJ78)


### Approach - 1 (Level Order)

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        if(root == null) return new ArrayList<>();
        
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer,Integer> map = new TreeMap<>();
        
        queue.add(new Pair(root, 0));
        
        while(!queue.isEmpty()) {
            Pair pair = queue.remove();
            
            if(!map.containsKey(pair.level)) {
                map.put(pair.level, pair.root.data);
            }
            
            if(pair.root.left != null) {
                queue.add(new Pair(pair.root.left, pair.level - 1));
            }
            if(pair.root.right != null) {
                queue.add(new Pair(pair.root.right, pair.level +1));
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
