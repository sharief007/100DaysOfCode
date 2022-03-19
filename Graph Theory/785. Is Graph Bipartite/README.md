
[785. Is Graph Bipartite?](https://leetcode.com/problems/is-graph-bipartite/)

There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:

There are no self-edges (graph[u] does not contain u).
There are no parallel edges (graph[u] does not contain duplicate values).
If v is in graph[u], then u is in graph[v] (the graph is undirected).
The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.

Return true if and only if it is bipartite.

Example - 1 : False

![Example Image](https://assets.leetcode.com/uploads/2020/10/21/bi2.jpg)

Example -2 : True

![Example Image](https://assets.leetcode.com/uploads/2020/10/21/bi1.jpg)

### Approach

[leetcode explanation](https://leetcode.com/problems/is-graph-bipartite/discuss/1852607/JAVA-Clean-BFS-Code-with-Written-Explaination)

```java
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        
        int[] color = new int[n];
        Arrays.fill(color, -1);
        
        // check for all nodes
        for(int i=0;i<n;i++) {
            if(color[i] == -1 && !validBipartite(i, graph, color)) return false;
        }
        return true;
    }
    
    private boolean validBipartite(int start, int[][] graph, int[] color) {
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        // start with color 1 
        color[start] = 1;
        
        while(!queue.isEmpty()) {
            int node = queue.remove();
            
            for(int neighb : graph[node]) {
                // no color assigned
                if(color[neighb] == -1) {
                    // if node color is 1, then 0
                    // if node color is 0, then 1
                    color[neighb] = 1 - color[node]; 
                    queue.add(neighb);
                }
                // neighbourhood nodes have same color
                if(color[neighb] == color[node]) return false;               
            }   
        }
        // no two neighbourhood nodes have same color
        return true;
    }
}
```