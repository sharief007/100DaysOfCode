
[121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

### Approach - 1 (Brute Force)

- Time Complexity: O(N^2)   ~ Time limit Exceeded (203/211)
- Space Complexity: O(1)

```java
class Solution {
    public int maxProfit(int[] prices) {
       int maxProfit = 0, n = prices.length;
        
        for(int i=0;i<n-1;i++) {
            for(int j=i;j<n;j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        
        return maxProfit;
    }
}
```

### Approach - 2 

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    public int maxProfit(int[] prices) {
                
        int min = Integer.MAX_VALUE, maxDiff = -1;
        for(int i: prices){
            min = Math.min(i,min);
            maxDiff = Math.max(maxDiff,i-min);
        }
        return maxDiff;
    }
}
```