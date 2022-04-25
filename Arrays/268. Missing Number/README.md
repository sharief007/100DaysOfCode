[268. Missing Number](https://leetcode.com/problems/missing-number/)

### Approach - 1 (Sorting)

### Approach - 2

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    public int missingNumber(int[] nums) {
        
        int n = nums.length, expectedSum = 0, actualSum = 0;
        
        expectedSum = (n * (n + 1)) / 2;
        
        for(int val: nums) {
           actualSum += val;
        }
        
        return Math.abs( expectedSum - actualSum);
    }
}
```