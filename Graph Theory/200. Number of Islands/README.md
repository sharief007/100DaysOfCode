[200. Number of Islands](https://leetcode.com/problems/number-of-islands/)

### Approach 

1. Traverse the grid, and apply DFS on finding '1'.
2. Mark visited cells to some other value to indicate already visited.
3. count islands on every new '1'.

- Time Complexity: O(N^4)
- Space Complexity: O(N)

```java
class Solution {
    public int numIslands(char[][] grid) {
        int len = grid.length, width = grid[0].length, island = 0;
        
        for(int i=0;i<len;i++) {
            for(int j=0;j<width;j++) {
                if(grid[i][j] == '1') {
                    exploreIsland(grid, i, j);
                    island++;
                }
            }
        }
        return island;
    }
    
    private void exploreIsland(char[][] grid, int r, int c ) {
        if(outOfBounds(grid, r, c)) return;
        
        if(grid[r][c] == '1') {
            grid[r][c] = '-';
            
            exploreIsland(grid, r, c+1);    //right
            exploreIsland(grid, r+1, c);    //down
            exploreIsland(grid, r, c-1);    //left
            exploreIsland(grid, r-1, c);    //up
        }
        
     }
    
    private boolean outOfBounds(char[][] grid, int row, int col) {
        int len = grid.length, width = grid[0].length;
        
        if(row<0 || row>=len || col<0 || col>=width) return true;
        return false;
    }
    
}
```
