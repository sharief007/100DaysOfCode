
[70. Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)

### Approach (Recursive)

- Time complexity: O(N)
- Space Complexity: O(N)

```java
class Solution {
    public int climbStairs(int n) {
        return climb(n, new HashMap<>());
    }
    
    private int climb(int n, Map<Integer,Integer> map) {
        if(map.containsKey(n)) return map.get(n);
        if(n <= 0) return 0;
        if(n <= 3) return n;
        int steps = climb(n-1, map) + climb(n-2, map);
        map.put(n, steps);
        return steps;
    }
}
```

### Approach (Iterative)

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
class Solution {
    public int climbStairs(int n) {
        int dp[]=new int[n];
        if(n==1){
            dp[0]=1;
        }
        else if(n>=2)
        {
            dp[0]=1;
            dp[1]=2;
        }
        
        for(int i=2;i<n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n-1];
        }
}
```