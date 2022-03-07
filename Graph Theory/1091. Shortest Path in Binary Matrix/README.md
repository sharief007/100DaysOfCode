[1091. Shortest Path in Binary Matrix](https://leetcode.com/problems/shortest-path-in-binary-matrix/)

### Approach (BFS)

- Time Complexity: O(N^2)
- Space Complexity: O(N)

```java
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        
        if(grid[0][0] == 1) return -1;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0,1));
        int[][] dir = {
            {0,1}, //left
            {1,1}, // down left
            {1,0}, //down
            {1,-1}, //down right
            {0,-1}, //right
            {-1,-1}, //right up
            {-1,0}, //up
            {-1,1} // up left
        };
                
        while(queue.size()>0) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                Point p = queue.remove();
                if(p.x == n-1 && p.y == m-1) {
                    return p.d;
                }
                for(int[] d : dir) {
                    int x = p.x + d[0], y = p.y + d[1];
                    if(isClear(grid,x,y)) {
                        queue.add(new Point(x,y,p.d+1));
                        grid[x][y] = -1;
                    }
                    
                }
            }
        }
        return -1;
    }
    
    private boolean isClear(int[][] grid, int i, int j) {
        int n = grid.length, m = grid[0].length;
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j] != 0) {
            return false;
        }
        return true;
    }
    
    
    private class Point {
        int x, y, d;
        Point(int x,int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    
}
```