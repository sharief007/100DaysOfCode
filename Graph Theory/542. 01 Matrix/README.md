[542. 01 Matrix](https://leetcode.com/problems/01-matrix/)

### Approach
- Time Complexity: O((N*M)^2)
- Space Complexity: O(N*M)

48/50 passed. TLE

```java
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        
        int[][] dist = new int[n][m];
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(mat[i][j] == 1) {
                    dist[i][j] = findNearestZero(mat, i, j);
                } else {
                    dist[i][j] = 0;
                }
            }
        }
        return dist;
    }
    
    private int findNearestZero(int[][] grid, int i, int j) {
        int steps = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        
        int[][] directions = new int[][] {
            {1,0}, {0,1}, {-1,0}, {0,-1}  
        };
        
        while(queue.size() > 0) {
            int size = queue.size();
            
            for(int k=0;k<size;k++) {
                int[] pnt = queue.remove();
                
                if(grid[pnt[0]][pnt[1]] == 0) return steps;
                
                for(int[] dir: directions) {
                    int x = pnt[0] + dir[0], y = pnt[1] + dir[1];
                    if(!isInValid(grid,x,y)) {
                        queue.add(new int[]{x, y});
                    }
                }
            }
            steps++;            
        }
        return steps;
    }
    
    private boolean isInValid(int[][] grid, int i, int j) {
        return (i<0 || i>= grid.length || j<0 || j>= grid[i].length);
    }
}
```

### Approach - 2 (stolen)
- Time Complexity: O(N*M)
- Space Complexity: O(N*M)

```java
class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[][] updateMatrix(int[][] mat) {
        int[][] ans = new int[mat.length][mat[0].length];
        for (int[] row: ans) Arrays.fill(row, Integer.MAX_VALUE); // can also do this in the loop below
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[0].length; c++) {
                if (mat[r][c] == 0) {
                    ans[r][c] = 0;
                    q.offer(new int[]{r, c});
                }
            }
        }
        int dist = 1; //can use get it from current node in the queue, but I prefer this
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int[] cur = q.poll();
                for (int[] dir: dirs) {
                    int nr = cur[0] + dir[0], nc = cur[1] + dir[1];
                    if (nr < 0 || nr >= mat.length || nc < 0 || nc >= mat[0].length || ans[nr][nc] != Integer.MAX_VALUE) continue;
                    ans[nr][nc] = dist;
                    q.offer(new int[]{nr, nc});
                }
            }
            dist++;
        }
        return ans;
    }
}
```