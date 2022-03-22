
[886. Possible Bipartition](https://leetcode.com/problems/possible-bipartition/)

We want to split a group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other people, and they should not go into the same group.

Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person labeled bi, return true if it is possible to split everyone into two groups in this way.

Example 1:

``` text
Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4] and group2 [2,3].
```

### Approach (Use graph coloring method)

- Time Complexity: O()
- Space Complexity: O()

```java
class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        
        int[] color = new int[n+1];
        Arrays.fill(color, -1);
        
        for(int i=0;i<=n;i++) {
            graph.add(new ArrayList<>());
        }
        
        // construct undirected graph
        for(int[] set: dislikes) {
            graph.get(set[0]).add(set[1]);
            graph.get(set[1]).add(set[0]);  // missed this line, gave error
        }
        
        
        for(int i=1;i<=n;i++) {
            if(color[i] == -1 && !validBipartite(i, graph, color)) return false;
        }
        return true;
    }
    
    private boolean validBipartite(int i, List<List<Integer>> graph, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        
        color[i] = 1;
        
        while(!queue.isEmpty()) {
            int node = queue.remove();
            
            for(int neigh : graph.get(node)) {
                if(color[neigh] == color[node]) return false;
                
                if(color[neigh] == -1) {
                    color[neigh] = 1 - color[node];
                    queue.add(neigh);
                }
            }
        }
        return true;
    }
    
}
```