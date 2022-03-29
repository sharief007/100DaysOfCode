
[583. Delete Operation for Two Strings](https://leetcode.com/problems/delete-operation-for-two-strings/)

Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

In one step, you can delete exactly one character in either string.

```text
Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
```

```text
Input: word1 = "leetcode", word2 = "etco"
Output: 4
```

### Approach - 1 (LCS)

[Youtube Explanation](https://www.youtube.com/watch?v=VSrsUkoG0bk)

answer =  word1.length + word2.length - 2 * LCS

### Approach - 2 (DP)

- Time Complexity: O(M*N)
- Space Complexity: O(M*N)

```java
class Solution {
    public int minDistance(String p, String q) {
        int n = p.length(), m = q.length();
        
        int[][] cache = new int[n+1][m+1];
                
        for(int i=0;i<cache.length;i++) {
            for(int j=0;j<cache[i].length;j++) {
                if(i==0 || j==0) {
                    cache[i][j] = i+j;
                } else if(p.charAt(i-1) == q.charAt(j-1)) {
                    cache[i][j] = cache[i-1][j-1];
                } else {
                    cache[i][j] = 1 + Math.min(cache[i][j-1], cache[i-1][j]);
                }
            }
        }
        return cache[n][m];
    }
}
```