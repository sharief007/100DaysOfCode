
[289. Game of Life](https://leetcode.com/problems/game-of-life/)

According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.

![Example Image](https://assets.leetcode.com/uploads/2020/12/26/grid1.jpg)

```text
Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
```

![Example Image](https://assets.leetcode.com/uploads/2020/12/26/grid2.jpg)

```text
Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]
```

### Approach - 1

- Time Complexity: (8 * (N*M)) => (N*M)
- Space Complexity: O(N*M)

```java
class Solution {
    
    private final int[][] directions = new int[][] {
            {-1,0}, {0,1}, {1,0}, {0,-1},   // north east south west
            {-1,1}, {1,1}, {1,-1}, {-1,-1}  // other 4 directions
        };
    
    public void gameOfLife(int[][] board) {
        int n = board.length, m = board[0].length;
        
        int[][] result = new int[n][m];
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                result[i][j] = calculate(board, i, j);
            }
        }
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                board[i][j] = result[i][j];
            }
        }
        
    }
    
    private int calculate(int[][] board, int i, int j) {
        int liveCells = 0, deadCells = 0;
        
        for(int[] dir: directions) {
            int x = i+dir[0], y = j+dir[1];
            if(!outOfBounds(board, x, y)) {
                if(board[x][y] == 0) {
                    deadCells++;
                } else {
                    liveCells++;
                }
            }
        }
        // System.out.printf("%s,%s\n",liveCells,deadCells);
        if(board[i][j] == 1) {
            if(liveCells < 2) {
                return 0;
            } else if(liveCells > 3) {
                return 0;
            } else {
                return 1;
            }
            
        } else {
            return liveCells == 3 ? 1 : board[i][j];
        }
        
    }
    
    private boolean outOfBounds(int[][] board, int i, int j) {
        return (i<0 || i>= board.length || j<0 || j>=board[i].length);
    }
    
    
}
```