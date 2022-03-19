
[802. Find Eventual Safe States](https://leetcode.com/problems/find-eventual-safe-states/)

### Approach 

Youtube Explanation
[Detect cycle in directed graph](https://www.youtube.com/watch?v=uzVUw90ZFIg)

- Time Complexity: O(N+E)
- Space Complexity: O(N)
- Auxiliary Space Complexity: O(N)

```java
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int size =  graph.length;
        
        boolean[] visited = new boolean[size];
        boolean[] dfsVisited = new boolean[size];
        
        boolean[] cyclicNode = new boolean[size];
        
        List<Integer> result = new LinkedList<>();
        
        for(int i=0;i<size;i++) {
            if( !visited[i]) {
                if(checkCycle(i, visited, dfsVisited, cyclicNode, graph)) {
                    cyclicNode[i] = true;
                }
            }
        }
        
        for(int i=0;i<size;i++) {
            if( !cyclicNode[i] ) {
                result.add(i);
            }
        }
        
        return result;
    }
    
    private boolean checkCycle(int i, boolean[] visited, boolean[] dfs, boolean[] cyclic, int[][] graph) {
        
        visited[i] = true;
        dfs[i] = true;
        
        for(int node : graph[i]) {
            
            if( !visited[node] ) {
                if(checkCycle(node, visited, dfs, cyclic, graph)) {
                    cyclic[node] = true;
                    return true;
                }
            } else if( dfs[node] ) {
                cyclic[node] = true;
                return true;
            }
        }
        
        dfs[i] = false;
        return false;        
    }
}
```