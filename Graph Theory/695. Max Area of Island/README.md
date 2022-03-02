[695. Max Area of Island](https://leetcode.com/problems/max-area-of-island/)

You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

![Example](https://assets.leetcode.com/uploads/2021/05/01/maxarea1-grid.jpg)

```text
Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
```

### Approach - 1

- Time Complexity: O((N*M)^2)
- Space Complexity: O(N)

```java
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int maxArea = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++) {
            for(int j =0;j<m;j++) {
                int area = getArea(grid, i, j);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea == Integer.MIN_VALUE ? 0 : maxArea;
    }
    
    private int getArea(int[][] grid, int i, int j) {
        if(isOutOfBounds(grid,i,j)) return 0;
        
        if(grid[i][j] == 0) {
            return 0;
        } else if (grid[i][j] == 1) {
            grid[i][j] = -1;
            
            return 1 + getArea(grid, i-1, j)
                     + getArea(grid, i, j+1)
                     + getArea(grid, i+1, j)
                     + getArea(grid, i, j-1);
            
        } else {
            return 0;
        }
    }
    
    private boolean isOutOfBounds(int[][] grid, int i,int j) {
        int n = grid.length, m= grid[0].length;
        
        if(i<0 || i>=n || j<0 || j>=m) {
            return true;
        }
        
        return false;        
    }
}
```