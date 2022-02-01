[59. Spiral Matrix 2](https://leetcode.com/problems/spiral-matrix-ii/)

### Approach -1

[Youtube Explanation](https://www.youtube.com/watch?v=1ZGJzvkcLsA)

Time Complexity : O(n2)
Space COmplexity: O(1)

```java
class Solution {
    public int[][] generateMatrix(int n) {
        int top = 0, down = n-1, left = 0, right = n-1;
        int count = 1, dir = 0;
        int[][] nums = new int[n][n];
        while(count <= n*n) {
            switch(dir) {
                case 0 : {  //right 
                    for(int i=left;i<=right;i++) {
                        nums[top][i] = count;
                        count++;   
                    }
                    top++;
                    break;
                }
                case 1: {   //down
                   for(int i=top;i<=down;i++) {
                       nums[i][right] = count;
                       count++;
                   } 
                    right--;
                    break;
                }
                case 2: {   // left
                    for(int i=right;i>=left;i--) {
                        nums[down][i] = count;
                        count++;
                    }
                    down--;
                    break;
                }
                case 3: {   //up
                    for(int i=down;i>=top;i--) {
                        nums[i][left] = count;
                        count++;
                    }
                    left++;
                    break;
                }
            }
            dir = (dir+1)%4;
        }
        return nums;
    }
}
```