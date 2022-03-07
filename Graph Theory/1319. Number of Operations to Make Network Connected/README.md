[1319. Number of Operations to Make Network Connected](https://leetcode.com/problems/number-of-operations-to-make-network-connected/)

### Approach (Stolen)

[Youtube Explanation](https://www.youtube.com/watch?v=3JIwIRir2sM)

you havem't sloved this 

```java
class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (n > connections.length + 1)
            return -1;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList());
        for (int i = 0; i < connections.length;i++){
            adjList.get(connections[i][0]).add(connections[i][1]);
            adjList.get(connections[i][1]).add(connections[i][0]);
        }
        boolean[] visited = new boolean[n];
        int components = 0;
        for (int i = 0; i<n; i++)
            if (!visited[i]){
                components++;
                dfs(adjList, i, visited);
            }
        return components -1;
        
    }
    private void dfs(List<List<Integer>> adjList, int i, boolean[] visited){
        visited[i]=true;
        for(int neighbor: adjList.get(i))
            if (!visited[neighbor])
                dfs(adjList, neighbor, visited);
    }
}
```