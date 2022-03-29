
[322. Coin Change](https://leetcode.com/problems/coin-change/)

```text
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
```

### Approach - 1

[Youtube Explanation](https://www.youtube.com/watch?v=H9bfqozjoqs)

[Youtube Explanation](https://www.youtube.com/watch?v=ZI17bgz07EE&t=350s)

```java
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int a = 1; a <= amount; a++)
            for (int c: coins)
                if (a-c>=0)
                    dp[a] = Math.min(dp[a], 1+ dp[a-c]);
        System.out.printf("%s", Arrays.toString(dp));
        return (dp[amount]== amount+1)?-1:dp[amount];
    }
}
```