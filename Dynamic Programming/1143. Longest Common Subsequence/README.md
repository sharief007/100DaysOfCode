[1143. Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/)

### Approach - 1 (Recursion)

[Youtube Explanation](https://www.youtube.com/watch?v=sSno9rV8Rhg)

### Approach - 2 (Memoization)

[Youtube Explanation](https://www.youtube.com/watch?v=sSno9rV8Rhg)

### Approach - 3

[Youtube Explanation](https://www.youtube.com/watch?v=sSno9rV8Rhg)

- Time Complexity: O(M*N)
- Space Complexity: O(M*N)

```java
class Solution {
    public int longestCommonSubsequence(String p, String q) {
        int n = p.length(), m = q.length();
        
        int[][] cache = new int[n+1][m+1];
        
        for(int i=1;i<cache.length;i++) {
            for(int j=1;j<cache[i].length;j++) {
                //System.out.printf("%s,%s\n",i,j);
                if(p.charAt(i-1) == q.charAt(j-1)) {
                    cache[i][j] = 1 + cache[i-1][j-1];
                } else {
                    cache[i][j] = Math.max(cache[i][j-1], cache[i-1][j]);
                }
            }
        }
        return cache[n][m];
    }
}
```