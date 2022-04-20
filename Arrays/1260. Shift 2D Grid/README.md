
[1260. Shift 2D Grid]()

Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.

In one shift operation:

Element at grid[i][j] moves to grid[i][j + 1].
Element at grid[i][n - 1] moves to grid[i + 1][0].
Element at grid[m - 1][n - 1] moves to grid[0][0].
Return the 2D grid after applying shift operation k times.

 ![Image](https://assets.leetcode.com/uploads/2019/11/05/e1.png)

```text
Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
Output: [[9,1,2],[3,4,5],[6,7,8]]
```

 ![Image](https://assets.leetcode.com/uploads/2019/11/05/e2.png)

 ```text
Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
 ```

### Approach 

- Think like: convert 2d array to 1d array. shift k elements to right. k right most elements comes to left side.


```java
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        // if shifting total times, it shifts back to orignal state
        k = k % (total);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {   
                // i * n + j original place index in 1D array
                // i * n + j - k  is to get value k steps before                 
                int index = ((i * n + j) - k + total) % total;  // index could be -ve. this is a trick to convert -ve to +ve. By adding total and modulos total.
                /*
                    example: arr index = 0, length = 5; k = 2
                    index - k = -2 
                    therefore index = -2
                    if we do (index + total) % total => (-2 + 5)%5 = 3
                    0th elements can be found at 3 now.
                */
                list.add(grid[index / n][index % n]);
            }
            result.add(list);
        }
        return result;
    }
}
```