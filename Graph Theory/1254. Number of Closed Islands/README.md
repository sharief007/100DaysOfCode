[1254. Number of Closed Islands](https://leetcode.com/problems/number-of-closed-islands/submissions/)

Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands.

![Example](https://assets.leetcode.com/uploads/2019/10/31/sample_3_1610.png)

```text
Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
Output: 2
Explanation: 
Islands in gray are closed because they are completely surrounded by water (group of 1s).
```

### Approach -1 
[Youtube Explanation](https://www.youtube.com/watch?v=QcY61aBwibI)

- Time Complexity: O((N*M)^2)
- Space Complexity: O(N) (Auxiliary stack space)

Dry run the code to understand the logic.

```java
class Solution {
    public int closedIsland(int[][] grid) {
        int islands = 0;
        
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                if(grid[i][j] == 0) { // this is an land
                    boolean closed = checkIsClosed(grid, i, j);
                    if(closed) islands++;
                }  
            }
        }
        return islands;
    }
    
    private boolean checkIsClosed(int[][] grid, int i, int j) {
        // outofbounds can be anything, either it can be water or land
        // so we take it as false
        if(isOutOfBounds(grid, i, j)) return false;
        
        // we have reached water, this means this border is filled with water and is inside grid so return true        
        if(grid[i][j] == 1) return true;
        
        // this has already been visited so mark it as 1.
        grid[i][j] = 1;     // dont mark it as anything else
        
        // check right border is filled with water and not outofbounds
        boolean right = checkIsClosed(grid, i, j+1);
        //check bottom border is filled with water and not outofbounds
        boolean bottom = checkIsClosed(grid, i+1, j);
        //check left border is filled with water and not outofbounds
        boolean left = checkIsClosed(grid, i, j-1);
        //check top border is filled with water and not outofbounds
        boolean top = checkIsClosed(grid, i-1, j);
        
        // all borders should be water only then only it is a closed island
        return right && bottom && left && top; 
    }
    
    private boolean isOutOfBounds(int[][] grid, int i, int j) {
        if(i<0 || i>= grid.length || j<0 || j>=grid[i].length) return true;
        return false;
    }
    
}
```