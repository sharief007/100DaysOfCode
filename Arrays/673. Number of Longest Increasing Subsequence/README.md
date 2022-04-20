[673. Number of Longest Increasing Subsequence](https://leetcode.com/problems/number-of-longest-increasing-subsequence/)

```text
Input: nums = [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
```

```text
Input: nums = [2,2,2,2,2]
Output: 5
Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
```

```text
Input: [1,1,1,2,2,2,3,3,3]
Output: 27
```

```text
Input: [100,90,80,70,60,50,60,70,80,90,100]
Output: 1
```

### Approach - 1 (DP)

Dry run to understand the logic. (LIS is prerequisite)

While finding LIS also find the frequency. Maintain two arrays, one for longest length of LIS till the index, other for frequency of LIS(combinations of LIS).

```java
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        
        int[] dp = new int[n], count = new int[n];
        
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        
        int maxLis = 1;
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(nums[i] > nums[j]) { // increasing sequence possible
                    if(dp[i] <= dp[j]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if(dp[j]+1 == dp[i]) {    // already one sequence exist
                        count[i] += count[j];   // instead of ++ use this
                    }
                }
            }
            maxLis = Math.max(maxLis, dp[i]);            
        }
        
        int result = 0;
        System.out.printf("%s\n%s", Arrays.toString(dp), Arrays.toString(count));
        for(int i=0;i<n;i++) {
            if(maxLis == dp[i]) {
                result += count[i];
            }
        }
        
        return result;
    }
}
```