[1905. Count Sub Islands](https://leetcode.com/problems/count-sub-islands/)

You are given two m x n binary matrices grid1 and grid2 containing only 0's (representing water) and 1's (representing land). An island is a group of 1's connected 4-directionally (horizontal or vertical). Any cells outside of the grid are considered water cells.

An island in grid2 is considered a sub-island if there is an island in grid1 that contains all the cells that make up this island in grid2.

Return the number of islands in grid2 that are considered sub-islands.

![Example](https://assets.leetcode.com/uploads/2021/06/10/test1.png)

```text
Input: grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]], grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
Output: 3
Explanation: In the picture above, the grid on the left is grid1 and the grid on the right is grid2.
The 1s colored red in grid2 are those considered to be part of a sub-island. There are three sub-islands.
```

### Approach - 1 (Stolen)

- Time Complexity: O(M*N)
- Space Complexity: O(M*N)

```text
return check(i+1,j) & check(i-1,j) & check(i,j+1) & check(i,j-1);
didn't understood this
```

```java
class Solution {

	int[][] grid1, grid2;
	public int countSubIslands(int[][] grid1, int[][] grid2) {
		this.grid1 = grid1;
		this.grid2 = grid2;
		int count = 0;
		for(int i=0;i<grid2.length;i++)
			for(int j=0;j<grid2[0].length;j++)
				if(grid2[i][j]==1 && check(i,j))
					count++;
		return count;
	}

	boolean check(int i, int j){
		if(i==-1||j==-1||i==grid2.length||j==grid2[0].length) return true;
        
        if(grid2[i][j]==0) return true;
        
		if(grid1[i][j]!=1) return false;
        
		grid2[i][j] = 0;
		return check(i+1,j) & check(i-1,j) & check(i,j+1) & check(i,j-1);
	}

}
```

### Approach - 2

[youtube explanation](https://www.youtube.com/watch?v=o1rVOYwcRd0)

- Time Complexity: O(N*M)
- Space Complexity: O(N*M)

```java
class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid2.length, m = grid2[0].length;
        int count = 0;
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid2[i][j] == 1) {
                    boolean[] flag = new boolean[]{true};
                    checkIsland(grid1, grid2, i, j, flag);
                    if(flag[0]) count++;
                }
            }
        }
        return count;
    }
    
    // we need to check if it exists in grid1 or not
    private void checkIsland(int[][] grid1, int[][] grid2, int i, int j, boolean[] flag) {
        // outOfbounds doesnt matter here
        if(outOfBounds(grid2, i, j)) {
            return;
        }
        // water cell
        if(grid2[i][j] == 0) {
            return ;
        }
        
        if(grid2[i][j] == 1) {
            // we have land in grid2 but we dont have land in grid1
            if(grid1[i][j] == 0) {  // so this cannot be an subisland
                flag[0] = false;
                return;
            }
            // mark as visited
            grid2[i][j] = 0;
        }
        
        checkIsland(grid1, grid2, i-1, j, flag);
        checkIsland(grid1, grid2, i+1, j, flag);
        checkIsland(grid1, grid2, i, j-1, flag);
        checkIsland(grid1, grid2, i, j+1, flag);
    }
    
    private boolean outOfBounds(int[][] grid, int i, int j) {
        return (i<0 || i>= grid.length || j<0 || j>=grid[i].length);
    }
}
```
