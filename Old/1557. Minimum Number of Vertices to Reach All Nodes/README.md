
[1557. Minimum Number of Vertices to Reach All Nodes](https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/)


Given a directed acyclic graph, with n vertices numbered from 0 to n-1, and an array edges where edges[i] = [fromi, toi] represents a directed edge from node fromi to node toi.

Find the smallest set of vertices from which all nodes in the graph are reachable. It's guaranteed that a unique solution exists.

Notice that you can return the vertices in any order

- Example 

![Example](https://assets.leetcode.com/uploads/2020/07/07/untitled22.png)

```text
Input: n = 6, edges = [[0,1],[0,2],[2,5],[3,4],[4,2]]
Output: [0,3]
Explanation: It's not possible to reach all the nodes from a single vertex. From 0 we can reach [0,1,2,5]. From 3 we can reach [3,4,2,5]. So we output [0,3].
```



### Approach (mine)

Find all the vertices which dont have any incoming edges, which means they are not accessible from any other vertex.

In other words, find the 0 index in all arrays which is not equal to 1 index in any other array. 

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] cache = new int[n];
        
        List<Integer> list = new LinkedList<>();
        for(List<Integer> edge : edges) {
            int to = edge.get(1);
            cache[to]++;
        }
        
        for(List<Integer> edge: edges) {
            int from = edge.get(0);
            if(cache[from] == 0) {
                list.add(from);
                cache[from] = -1;
            }
        }
        return list;
    }
}
```