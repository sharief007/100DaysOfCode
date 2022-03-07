[934. Shortest Bridge](https://leetcode.com/problems/shortest-bridge/)

You are given an n x n binary matrix grid where 1 represents land and 0 represents water.

An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.

You may change 0's to 1's to connect the two islands to form one island.

Return the smallest number of 0's you must flip to connect the two islands.


### Approach (DFS + BFS)

- Time Complexity: O(N*M)
- Space Complexity: O(N*M)

```java
class Solution {
    int rows;
    int cols;
    public int shortestBridge(int[][] grid) {
        rows = grid.length; cols = grid[0].length;
        if (rows == 0 || cols == 0) return -1;
        Queue<int[]> q = new LinkedList<>(); 
        boolean found = false;
        for (int i = 0; i < rows && !found; ++i) {
            for (int j = 0; j < cols && !found; ++j) {
                if (grid[i][j] == 1) {
                    findandMarkIsland(grid, q, i, j);
                    found = true;
                }
            }
        }
        int result = -1;
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        while (!q.isEmpty()) {
            int qSize = q.size();
            ++result;
            for (int i = 0; i < qSize; ++i) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int nx = curr[0] + dir[0], ny = curr[1] + dir[1];
                    if (nx < 0 || nx >= rows || ny < 0 || ny >= cols || grid[nx][ny] == -1) {
                        continue;
                    }
                    if (grid[nx][ny] == 1) return result;
                    q.offer(new int[] {nx, ny});
                    grid[nx][ny] = -1;
                }
            }
        }
        return result;
    }
    
    private void findandMarkIsland(int[][] grid, Queue<int[]> q, int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] != 1) return;
        q.offer(new int[] {i, j}); 
        grid[i][j] = -1;
        findandMarkIsland(grid, q, i + 1, j);
        findandMarkIsland(grid, q, i - 1, j);
        findandMarkIsland(grid, q, i, j + 1);
        findandMarkIsland(grid, q, i, j - 1);
        
    }
}
```