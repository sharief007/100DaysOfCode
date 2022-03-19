
[1129. Shortest Path with Alternating Colors](https://leetcode.com/problems/shortest-path-with-alternating-colors/)

### Approach 

1. Create an Adjacency matrix using the red and blue edges given.
2. Use 1 to denote the edge as red, -1 for blue. and use 0 if both red and blue edges exist between two nodes.
3. Otherwise use -N to indicate no edge (where n is total number of nodes)
4. Use a queue of array to start BFS. Array contains two elements i.e. node and color.
5. The first edge can be either blue or red. So initially add both values to the Queue.
6. Use a hashset of string to track already visted nodes.

[Youtube Explanation](https://leetcode.com/problems/shortest-path-with-alternating-colors/)


- Time Complexity: O(N+E)
- Space Complexity: O(N^2)

```java
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        int[][] graph = constructGraph(n, redEdges, blueEdges);
        
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{0,1});  // start from node 0 with red
        queue.add(new int[]{0,-1}); // start from node 0 with blue
        
        // cycles may exist, so use set to track visited nodes
        HashSet<String> visited = new HashSet<>();
        // result array storing the distance from node 0
        int[] result = new int[n];
        // initially fill the array with max value
        Arrays.fill(result, Integer.MAX_VALUE);
        // distance from node 0 to node 0  = 0.
        result[0] = 0;
        
        
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;
            
            for(int i=0;i<size;i++) {
                int[] curr = queue.remove();
                
                int node = curr[0], color = curr[1];
                
                // loop through all neighbour nodes and check for opposite edge
                // start from 1 not from 0. 0 is already set and this is directed graph
                for(int j = 1; j<n;j++) {
                    // all neighbour edges of curr node
                    int neigh = graph[node][j];
                    // check if opposite or both
                    if(neigh == -color || neigh == 0) { 
                        // check if the edge is already used/visited
                        if(visited.add(String.format("%s$%s",j,-color))){
                            // the edge is not visited
                            queue.add(new int[]{j, -color});

                            // multiple paths may exist, we need shortest path.
                            result[j] = Math.min(result[j], level);
                        }
                    }
                }
            }
        }
        for(int i=0;i<n;i++) {
            // if distance is max then it is not reachable
            result[i] = result[i] == Integer.MAX_VALUE ? -1 : result[i];
        }
        return result;        
    }
    
    private int[][] constructGraph(int n, int[][] red, int[][] blue) {
        int[][] graph = new int[n][n];
        
        for(int[] neighbour : graph) {
            // initially fill all values with -n
            Arrays.fill(neighbour, -n);
        }
        
        // red edges
        for(int[] redEd: red) {
            int from = redEd[0], to = redEd[1];
            graph[from][to] = 1;
        }
        
        // blue or both the edges
        for(int[] blueEd: blue) {
            int from = blueEd[0], to = blueEd[1];
            graph[from][to] = graph[from][to] == 1 ? 0 : -1;
        }
        
        return graph;
    }    
}
```

Dry Run Example

``` text
5
[[0,1],[1,2],[2,3],[3,4]]
[[1,2],[2,3],[3,1]]
```