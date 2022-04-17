[397. Integer Replacement](https://leetcode.com/problems/integer-replacement/)

Given a positive integer n, you can apply one of the following operations:

- If n is even, replace n with n / 2.
- If n is odd, replace n with either n + 1 or n - 1.

Return the minimum number of operations needed for n to become 1.

### Approach (Recursion, Memoization)

- Time Complexity: O(LogN)
- Space Complexity: O(1) ~ ignore auxiliary stack space

```java
class Solution {
    public int integerReplacement(int n) {
        return calc(n, new HashMap<>());
    }
    
    private int calc(long n, Map<Long, Integer> map) {        
        if(n <= 1) return 0;
        
        if(map.containsKey(n)) return map.get(n);
        
        int ops = 0;
        
        if(n%2 == 0) {
            ops = 1 + calc(n/2, map);
        } else {
            ops = 1 + Math.min( calc(n+1, map), calc(n-1, map));
        }
        
        map.put(n, ops);
        return ops;
    }
}
```