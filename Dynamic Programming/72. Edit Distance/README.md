
[72. Edit Distance](https://leetcode.com/problems/edit-distance/)

### Approach - 1 (DP)

[Youtube Explanation](https://www.youtube.com/watch?v=We3YDTzNXEk)

- Time Complexity: O(M*N)
- Space Complexity: O(M*N)

```java
class Solution {
    public int minDistance(String p, String q) {
        int n = p.length(), m = q.length();
        
        int[][] cache = new int[n+1][m+1];
        
        for(int i=0;i<cache.length;i++) {
            cache[i][0] = i;
        }
        
        for(int i=0;i<cache[0].length;i++) {
            cache[0][i] = i;
        }
        
        for(int i=1;i<cache.length;i++) {
            for(int j=1;j<cache[i].length;j++) {
                if(p.charAt(i-1) == q.charAt(j-1)) {
                    cache[i][j] = cache[i-1][j-1];
                } else {
                    cache[i][j] = 1 + Math.min(cache[i-1][j-1], Math.min(cache[i][j-1], cache[i-1][j]));
                }
            }
        }
        return cache[n][m];
    }
}
```