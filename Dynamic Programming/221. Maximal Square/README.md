[221. Maximal Square](https://leetcode.com/problems/maximal-square/)

### Approach (Brute Force)

- Time Complexity: O((N*M)^2)
- Space Complexity: O(1)

```java
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length==0)
            return 0;
        int rows=matrix.length;
        int cols=matrix[0].length;
        int maxLen=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]=='1'){
                    int sqLen=1;
                    boolean square=true;
                    while(i+sqLen<rows&&j+sqLen<cols&&square){
                        for(int k=i;k<=i+sqLen;k++){
                            if(matrix[k][j+sqLen]=='0'){
                                square=false;
                                break;
                            }
                        }
                        for(int k=j;k<=j+sqLen;k++){
                            if(matrix[i+sqLen][k]=='0'){
                                square=false;
                                break;
                            }
                        }
                        if(square)
                            sqLen++;
                    }
                    if(sqLen>maxLen)
                        maxLen=sqLen;
                }
            }
        }
        return maxLen*maxLen;
    }
}
```

### Approach - 2(DP)

- Time Complexity: O(N*M
- Space Complexity: O(N*M)

```java
class Solution {
    public int maximalSquare(char[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        
        int[][] dp = new int[r][c];
        
        int largeSide = 0;
        
        for(int i=0;i<r;i++) {
            largeSide = matrix[i][0] == '1' ? 1 : largeSide;
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
        }
        
        for(int j=0;j<c;j++) {
            largeSide = matrix[0][j] == '1' ? 1 : largeSide;
            dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
        }
        
        for(int i=1;i<r;i++) {
            for(int j=1;j<c;j++) {
                if(matrix[i][j] == '1') {
                    dp[i][j] = 1 + Math.min(
                              dp[i-1][j-1],
                              Math.min(dp[i-1][j], dp[i][j-1])
                            );
                    largeSide = Math.max(largeSide, dp[i][j]);
                }
            }
        }
        return largeSide * largeSide;
    }
}
```