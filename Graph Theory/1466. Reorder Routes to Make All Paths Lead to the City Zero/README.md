
[1466. Reorder Routes to Make All Paths Lead to the City Zero](https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/)


There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.

This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.

It's guaranteed that each city can reach city 0 after reorder.


![Example Image](https://assets.leetcode.com/uploads/2020/05/13/sample_1_1819.png)

### Approach 

- Time Complexity: O(N+E)
- Space Compexity: O(N)

```java
class Solution {
    public int minReorder(int n, int[][] connections) {
        
        List<List<Integer>> list = new ArrayList<>();
        constructGraph(n, connections, list);
        
        boolean[] visited = new boolean[n];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        
        
        int count = 0;
        while(!queue.isEmpty()) {
            int curr = queue.remove();

            // all neighbour nodes
            for(int node : list.get(curr)) {
                int abs = Math.abs(node);
                
                // if this node is not visited already
                if(!visited[abs]) {
                    // mark it as visited
                    visited[abs] = true;                
                    
                    if(node > 0) count++;
                    queue.add(abs);
                }
            } 
        }
        return count;        
    }
    
    private void constructGraph(int n, int[][] conn, List<List<Integer>> list) {
        for(int i=0;i<n;i++) {
            list.add(new ArrayList<>());
        }
        // create adjacencey list using adjacency matrix
        for(int[] edge: conn) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(-edge[0]); //make it bidirectional
        }        
    }
}
```