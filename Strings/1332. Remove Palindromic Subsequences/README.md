
[1332. Remove Palindromic Subsequences](https://leetcode.com/problems/remove-palindromic-subsequences/)

### Approach 

[Explanation](https://leetcode.com/problems/remove-palindromic-subsequences/discuss/2124240/One-Major-Observation-or-JAVA-Explanation)

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    public int removePalindromeSub(String s) {
        return s.equals(new StringBuilder(s).reverse().toString()) ? 1 : 2;
    }
}
```