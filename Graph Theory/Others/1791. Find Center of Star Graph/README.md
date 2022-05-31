[1791. Find Center of Star Graph](https://leetcode.com/problems/find-center-of-star-graph/)

### Approach - 1 (Find mid of the graph)

[Amazing Youtube Explanation](https://youtube.com/watch?v=nzF_9bjDzdc)

```java
class Solution {
    public int findCenter(int[][] edges) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(edges, graph);
        
        int n = graph.size();
        int[] degree = new int[n+1];
        
        List<Integer> leaves = new ArrayList<>();
        
        for(int key: graph.keySet()) {
            degree[key] = graph.get(key).size();
            
            if(degree[key] == 0 || degree[key] == 1) {
                leaves.add(key);
            }
        }
        
        int count = leaves.size();
        
        while(count < n) {
            List<Integer> newLeaves = new ArrayList<>();
            
            for(int node: leaves) {
                for(int neigh: graph.get(node)) {
                    
                    degree[neigh]--;
                    
                    if(degree[neigh] == 1) {
                        newLeaves.add(neigh);
                    }
                }
            }
            leaves = newLeaves;
            count += newLeaves.size();
        }
        
        return leaves.get(0);
    }
    
    private void buildGraph(int[][] edges, Map<Integer,List<Integer>> graph) {
        for(int[] edge : edges) {
            int from = edge[0], to = edge[1];
            
            List<Integer> neighbours = graph.getOrDefault(from, new ArrayList<>());
            neighbours.add(to);
            graph.put(from, neighbours);
            
            neighbours = graph.getOrDefault(to, new ArrayList<>());
            neighbours.add(from);
            graph.put(to, neighbours);
        }
    }
}
```