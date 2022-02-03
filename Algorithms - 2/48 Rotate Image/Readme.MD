
[48. Rotate Image](https://leetcode.com/problems/rotate-image/)

![matrix](https://assets.leetcode.com/uploads/2020/08/28/mat1.jpg)

### Approach - 1

1. Transponse the given matrix
2. reverse elements in every column 

Time complexity: O(n^2)

Space Complexity: O(1)

```java
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // transpose matrix
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                transpose(matrix, i, j);
            }
        }
        //reverse elements in every row
        for(int i=0;i<n;i++) {
            int f = 0, l = n-1;
            while(f<l) {
                swap(matrix, i, f, l);
                f++;
                l--;
            }
        }
    }
    
    // row <-> col
    private void transpose(int[][] matrix, int i,int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
    
    // swap elements of same row    
    private void swap(int[][] matrix, int i, int f, int l) {
        int temp = matrix[i][f];
        matrix[i][f] = matrix[i][l];
        matrix[i][l] = temp;
    }
    
}
```