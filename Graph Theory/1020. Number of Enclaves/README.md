[1020. Number of Enclaves](https://leetcode.com/problems/number-of-enclaves/)

You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

![Example](https://leetcode.com/problems/number-of-enclaves/)

```text
Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
```

### Approach -1 (Mine)

[Youtube Explanation](https://www.youtube.com/watch?v=IeECyujWq1g)

- Time Complexity: O(n*m)
- Space Complexity: O(n*m)

```java
class Solution {
    int enclaveSize = 0;
    public int numEnclaves(int[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                
                if(grid[i][j] == 1) {   // it is a land
                    enclaveSize = 0;
                    boolean reachable = canReachBoundary(grid, i, j);
                    if(!reachable) count+=enclaveSize;                    
                }
            }
        }
        
        return count;        
    }
    
    private boolean canReachBoundary(int[][] grid, int i,int j) {
        // there is a path to reach boundary
        if(isOutOfBounds(grid, i, j)) return true;
        
        // blocked by water, cant move further so this is not the path
        if(grid[i][j] == 0) return false;
        
        enclaveSize++;
        
        // mark the land as visited, else cycle may occur
        grid[i][j] = 0;
        
        // check right direction
        boolean right = canReachBoundary(grid, i, j+1); 
        
        //check down direction
        boolean down = canReachBoundary(grid, i+1, j);
        
        //check left direction
        boolean left = canReachBoundary(grid, i, j-1);
        
        // check up direction
        boolean up = canReachBoundary(grid, i-1, j);
        
        //check if any direction leads us to boundary
        return right || left || down || up ;
        
    }
    
    private boolean isOutOfBounds(int[][] grid, int i, int j) {
        if(i<0 || i>= grid.length || j<0 || j>= grid[i].length) return true;
        return false;
    }
    
}
```