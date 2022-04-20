
[73. Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/)

![Image](https://assets.leetcode.com/uploads/2020/08/17/mat1.jpg)

[Youtube Explanation](https://www.youtube.com/watch?v=M65xBewcqcI&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=7)

### Approach - 1

works only if numbers are uppercase

- Time Complexity: O( (N*M) * (N+M) )
- Space Complexity: O(1)

```java

```

### Approach - 2 

1. Use 2 arrays, one of size row and other of size column.
2. Traverse the array using i,j pointers. If you encounter a zero value update the row[i] = true and column[j] = true.
3. Traverse again the array and upadte the matrix[i][j] = 0, if row[i] or col[j] is true.

- Time Complexity: O(N*M)
- Space Complexity: O(N+M)

```java
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m], col = new boolean[n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j]==0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(row[i]==true || col[j]==true) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
```

### Approach - 3 (Optimal)

Instead of using row, col arrays use two boolean variables. Use first row and first column as your cache. 

- Initially check if there exists any zero value in first zero or first column. if exists it means the first row or first col should be updated as zero.
- But we will do it at the end, because we are going to use these first row and first column as our cache.
- traverse from (1,1) to (n,m). mark the (0,i) & (j,0) as 0, when matrix[i][j] = 0
- traverse again from (1,1) to (n,m), mark matrix[i][j] as 0 if (0,i) or (j,0) is 0.
- Finally update the first row and first column if there exists any zero initially.

- Time Complexity: O(N*M)
- Space Complexity: O(1)

```java
class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean rowZero = false, colZero = false;
        
        for(int i=0;i<n;i++) {
            colZero = matrix[i][0] == 0 ? true : colZero;
        }
        
        for(int i=0;i<m;i++) {
            rowZero = matrix[0][i] == 0 ? true : rowZero;
        }
        
        
        for(int i=1;i<n;i++) {
            for(int j=1;j<m;j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0; 
                }
            }
        }
        
        for(int i=1;i<n;i++) {
            for(int j=1;j<m;j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(rowZero) {
            for(int i=0;i<m;i++) {
                matrix[0][i] = 0;
            }
        }
        
        if(colZero) {
            for(int i=0;i<n;i++) {
                matrix[i][0] = 0;
            }
        }
        
    }
}
```