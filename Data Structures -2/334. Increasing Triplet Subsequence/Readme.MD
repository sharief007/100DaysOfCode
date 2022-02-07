
[334. Increasing Triplet Subsequence](https://leetcode.com/problems/increasing-triplet-subsequence/)

Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

### Approach

Time Complexity: O(n)
Space Complexity: O(1)

```java
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            if(second < nums[i]) return true;
            if(first < nums[i]) second = Math.min(second, nums[i]);
            first = Math.min(first, nums[i]);
        }
        return false;
    }
}
```