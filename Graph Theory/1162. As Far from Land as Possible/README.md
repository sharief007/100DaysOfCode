
[1162. As Far from Land as Possible](https://leetcode.com/problems/as-far-from-land-as-possible/)

### Approach - 1 (Not sure if 100% correct)

10/37 test cases passed. TLE

- Time Complexity: O((N*M)^2)
- Space Complexity: O(N*M)

```java
class Solution {
    
    public int maxDistance(int[][] grid) {
        int maxDistance = -1;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                if(grid[i][j] == 0) {
                    int distance = distanceToLand(grid, i, j, 0);
                    System.out.printf("%s ",distance);
                    if(distance != Integer.MAX_VALUE) {
                        maxDistance = Math.max(maxDistance, distance);
                    }
                }
            }
        }
        System.out.printf("\n");
        return maxDistance;
    }
    
    private int distanceToLand(int[][] grid, int i,int j, int d) {
        if(i<0 || i>= grid.length || j<0 || j>= grid[i].length) {
            return Integer.MAX_VALUE;
        }
        
        if(grid[i][j] == 1) return d;
        
        if(grid[i][j] == -1) return Integer.MAX_VALUE;
        
        grid[i][j] = -1;
        
        int right = distanceToLand(grid, i, j+1, d+1);
        int left = distanceToLand(grid, i, j-1, d+1);
        int up = distanceToLand(grid, i-1, j, d+1);
        int down = distanceToLand(grid, i+1, j, d+1);
        
        grid[i][j] = 0;
        // System.out.printf("%s,%s,%s,%s\n",right,left,up,down);
        return Math.min( Math.min(left,right), Math.min(up,down));
    }
    
}
```

### Approach - 2 (Use BFS)

[Youtube Explanation](https://www.youtube.com/watch?v=yV-b0amHNVM)

- Time Complexity: O(N*M)
- Space Complexity: O(N*M)

```java
class Solution {
    
    public int maxDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                if(grid[i][j] == 1) {
                    queue.add(new int[]{i,j});
                    grid[i][j] = -1;
                }
            }
        }
        
        int[][] directions = new int[][] {
            {0,1},
            {1,0},
            {0,-1},
            {-1,0}
        };
        
        int levels = -1;
        while(queue.size() > 0) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                int[] pnt = queue.remove();
                int x = pnt[0], y = pnt[1];

                for(int[] dir: directions) {
                    int X = x+dir[0], Y = y+dir[1];
                    if(isValid(grid, X ,Y)) {
                        queue.add(new int[]{X, Y});
                        grid[X][Y] = -1;
                    }
                }
            }
            levels++;
        }
        return levels == 0 ? -1 : levels;
    }
    
    private boolean isValid(int[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>= grid[i].length) return false;
        
        return grid[i][j] != -1;
        
    }
    
}

```