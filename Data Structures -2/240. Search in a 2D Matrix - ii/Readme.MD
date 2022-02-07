
[240. Search in a 2D Matrix - ii](https://leetcode.com/problems/search-a-2d-matrix-ii/)

### Approach - 1
Apply Binary search Row wise

- Time Complexity: O(Nlogn)
- Space Complexity: O(1)

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        
        for(int[] mat: matrix) {
            if(Arrays.binarySearch(mat, target) >= 0) {
                return true;
            }
        }
        return false;
    }
}
```

### Approach - 2

1. Start from top-right corner
2. if val > target move downwards
3. else move towards left

Time Complexity: O(n)
Space Complexity: O(1)

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length,i=0,m = matrix[0].length,j=m-1;
        while(i<n && j>=0) {
            if(matrix[i][j] > target) {
                j--;
            } else if(matrix[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}
```