
[1926. Nearest Exit from Entrance in Maze](https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/)

You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.

In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.

Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.

![Example Image](https://assets.leetcode.com/uploads/2021/06/04/nearest1-grid.jpg)

### Approach (Mine)

- Time Complexity: O(N*M)
- Space Complexity: O(N*M)

```java
class Solution {
    public int nearestExit(char[][] grid, int[] entrance) {
        Queue<int[]> queue = new LinkedList<>();
        
        final int[][] directions = new int[][] {
            {1,0}, {0,1}, {-1,0}, {0,-1}  
        };
        
        queue.offer(entrance);
        // mark it as already visited, this is important
        grid[entrance[0]][entrance[1]] = '+';
        
        int levels = 0;
        while(queue.size() > 0) {
            int size = queue.size();

            for(int i=0;i<size;i++) {
                int[] point = queue.remove();
                
                for(int[] dir : directions) {
                    // boundary cordinates
                    int x = point[0] + dir[0], y = point[1] + dir[1];
                    
                    // if the entrance point is at boundary we shouldn't consider it.
                    // if the entrance point is at boundary then number of levels will be 0.
                    if(outOfBounds(grid, x, y)) {
                        if(levels != 0) return levels;                       
                    } else {
                        // if already visited then skip this route
                        if(grid[x][y] == '+') continue;
                    
                        // add this block to queue
                        queue.offer(new int[]{x,y});
                        grid[x][y] = '+';
                    }
                }                
            }
            // increments the levels
            levels++;
        }
        // all possible paths have been traversed and we are not able to find a way out of maze
        // so return -1
        return -1;
    }
    
    private boolean outOfBounds(char[][] grid, int i, int j) {
        return (i<0 || i>= grid.length || j<0 || j>= grid[i].length );
    }
    
}
```