[746. Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/)

### Approach (Recursive - NOT DP - NOT Tested)

- Time Complexity: O(2 ^ N)
- Space Complexity: O(N)

```java
class Solution {
    
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(minCost(cost,0,0), minCost(cost, 1,0));
    }
    
    private int minCost(int[] cost, int idx, int sum) {
        if(idx >= cost.length ) return sum;
        
        int oneStep = minCost(cost, idx + 1, sum + cost[idx]);
        int twoSteps = minCost(cost, idx + 2, sum + cost[idx]);
        
        int minCost =  Math.min(oneStep, twoSteps);
        
        return minCost;
    }
    
}
```

### Approach - 1 (Iterative)

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
class Solution {
    
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n == 1) return cost[0];
        
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        for(int i=2;i<n;i++) {
            dp[i] = Math.min(dp[i-1], dp[i-2])    + cost[i];
        }
        return Math.min(dp[n-2], dp[n-1]);   
    }
    
}
```
