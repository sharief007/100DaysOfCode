[64. Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/)

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

![Example](https://assets.leetcode.com/uploads/2020/11/05/minpath.jpg)

### Approach - (DP)

[Youtube Explanation](https://www.youtube.com/watch?v=t1shZ8_s6jc)

- Time Complexity: O(N*M)
- Space Complexity: O(1)

```java
class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length <= 0) return 0;
        
        int r = grid.length, c = grid[0].length;
        for(int i=1;i<r;i++) {
            grid[i][0] += grid[i-1][0];
        }
        
        for(int i=1;i<c;i++) {
            grid[0][i] += grid[0][i-1];
        }
        
        for(int i=1;i<r;i++) {
            for(int j=1;j<c;j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        
        return grid[r-1][c-1];
    }
}
```