
[417. Pacific Atlantic Water Flow](https://leetcode.com/problems/pacific-atlantic-water-flow/)

There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.

![Example](https://assets.leetcode.com/uploads/2021/06/08/waterflow-grid.jpg)

```text
Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
```

### Approach - 1

[LeetCode Discussion](https://leetcode.com/problems/pacific-atlantic-water-flow/discuss/1812839/Easy-to-understand-or-Java-or-DFS-or-5ms)

- Time Complexity: O(N*M)
- Space Complexity: O(N*M)

```java
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new LinkedList<>();
        int n = heights.length, m = heights[0].length;
        
        boolean[][] pacific = new boolean[n][m], atlantic = new boolean[n][m];
        
        for(int i=0;i<n;i++) {
            dfs(heights, pacific, i, 0, -1); //-1 refers to height of ocean
            dfs(heights, atlantic, i, m-1, -1); //-1 refers to height of ocean
        }
        
        for(int i=0;i<m;i++) {
            dfs(heights, pacific, 0, i, -1); //-1 refers tp height of ocean
            dfs(heights, atlantic, n-1, i, -1); // -1 refers to height of ocean
        }
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(pacific[i][j] && atlantic[i][j]) { // water can flow to both
                    list.add(List.of(i,j));
                }
            }
        }
        return list;
    }
    
    private void dfs(int[][] heights, boolean[][] ocean, int i, int j, int height) {
        //out of bounds
        if(i<0||i>=heights.length || j<0|| j>= heights[i].length) return;
        
        //inside cells height should be greater than that of borders
        // then only water can flow outside
        if(heights[i][j] < height) return;
        
        // already visited
        if(ocean[i][j]) return;
        
        int[][] directions = new int[][] {
            {0,1}, {1,0}, {-1, 0}, {0,-1}
        };
        
        ocean[i][j] = true;
        
        for(int[] dir: directions) {
            dfs(heights, ocean, i+dir[0], j+dir[1], heights[i][j]);
        }
        
    }
    
}
```