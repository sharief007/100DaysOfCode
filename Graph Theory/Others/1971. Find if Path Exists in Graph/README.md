
[1971. Find if Path Exists in Graph](https://leetcode.com/problems/find-if-path-exists-in-graph/)

There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

You want to determine if there is a valid path that exists from vertex source to vertex destination.

Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.

![Image](https://assets.leetcode.com/uploads/2021/08/14/validpath-ex1.png)

```text
Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
Output: true
Explanation: There are two paths from vertex 0 to vertex 2:
- 0 → 1 → 2
- 0 → 2
```

![Image](https://assets.leetcode.com/uploads/2021/08/14/validpath-ex2.png)

```text
Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
Output: false
Explanation: There is no path from vertex 0 to vertex 5.
```

### Approach - 1 (DFS - stolen)

- Time Complexity: O(N+E)   ~ 370ms
- Space Complexity: O(N)

```java
class Solution {

    // Approach 2 -> DFS
    boolean pathFound = false;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination)
            return true;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        // build Graph
        buildGraph(n, edges, graph);
        // DFS on the graph to uncover all the paths
        dfs(graph, source, destination, new boolean[n]);
        return pathFound;
    }

    // create a graph with bidirectional edges between the vertices
    public void buildGraph(int n, int[][] edges, Map<Integer, List<Integer>> graph) {
        for (int i=0; i<n; i++)
            graph.put(i, new ArrayList<>());

        //construct graph, add bidirectional vertex
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    }

    private void dfs(Map<Integer, List<Integer>> graph, int source, int destination, boolean[] visited) {
        // base condition
        if (visited[source] || pathFound)
            return;
        
        // mark the node visited
        visited[source] = true;
        for (int node : graph.get(source)) {
            // if this node is the destination
            if (node == destination) {
                pathFound = true;
                break;
            }
            // if the node didn't have a path through it, don't go through this path
            if (!visited[node])
                dfs(graph, node, destination, visited);
        }
        return;
    }
}
```

### Approach - 2 (BFS)

- Time Complexity: O(N+E)   ~ 262ms
- Space Complexity: O(N)    ~230MB

```java
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(graph, edges);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        Set<Integer> visited = new HashSet<>();
        visited.add(source);
        
        while(queue.size() > 0) {
            int node = queue.poll();
            
            if(node == destination) return true;    // destination is reachable
            
            for(int neighbours : graph.get(node)) {
                if(visited.add(neighbours)) {   // if not visisted already
                    queue.offer(neighbours);
                }
            }
        }
        return false;
    }
    
    // build bi-directional graph
    private void buildGraph(Map<Integer, List<Integer>> graph, int[][] edges) {
        for(int[] edge: edges) {
            int src = edge[0], dest = edge[1];
            
            List<Integer> list = graph.getOrDefault(src, new ArrayList<Integer>());
            list.add(dest);
            graph.put(src, list);
            
            list = graph.getOrDefault(dest, new ArrayList<Integer>());
            list.add(src);
            graph.put(dest, list);
        }
    }
    
}
```

### Approach - 3 (Union Find) ~ Effective solution

- Time Complexity: O(N+E)
- Space Complexity: O(N)

```java
class Solution {
    
    private class UnionFind {
        private int[] cache;
        
        public UnionFind(int n) {
            this.cache = new int[n];
            for(int i=0;i<n;i++) {
                cache[i] = i;
            }
        }
        
        // find the root value
        public int root(int n) {
            if(cache[n] == n) return n;
            return cache[n] = root(cache[n]);   // this will reduce the hireracy height
        }
        
        public void union(int x, int y) {
            int rootX = root(x), rootY = root(y);
            
            if(rootX != rootY) {    // they both are not connected
                if(rootX > rootY) {
                    cache[rootY] = rootX;   // make a connection
                } else {
                    cache[rootX] = rootY;   // make a connection
                }
            }
        }
        
    }
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.root(source) == uf.root(destination); // if they both have the same root means they are connected some way either directly or indirectly 
    }
}
```