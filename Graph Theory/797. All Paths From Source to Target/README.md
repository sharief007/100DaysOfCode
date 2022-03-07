[797. All Paths From Source to Target](https://leetcode.com/problems/all-paths-from-source-to-target/)

Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).

![Example](https://assets.leetcode.com/uploads/2020/09/28/all_1.jpg)

### Approach (DFS)

- Time Complexity: O(N*M)
- Space Complexity: O(N*M) (Auxiliary Stack space)

```java
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(graph, 0, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void dfs(int[][] grid, int idx,List<Integer> path,List<List<Integer>> result) {
        
        path.add(idx);
        
        if(idx >= grid.length-1) {
            result.add(path);
            return;
        }

        for(int x : grid[idx]) {
            dfs(grid, x, new ArrayList<>(path), result);
        }
    }
    
}
```