
[209. Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)

### Approach - 1

1. Since we need contigous size, we need to find the length of sliding window to be used.
2. We can find the smallest sliding window length satisfying the condition using binary search.
3. Apply binary search, use 1 and length as the boundries instead of 0 to n-1, because size cannot be 0, and it can be full length of array.
4. Find the mid value (use (i+j)/2 dont know why), apply sliding window of mid size.
5. If sum of sliding window is greater than target, then update the answer and reduce the mid i.e high = mid -1;
6. else increase the size i.e low = mid +1; but dont update the answer because we need smallest value.

- Time Complexity: O(N * LogN)
- Space Complexity: O(1)

```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 1, j = nums.length, result = 0;
        
        while(i<=j) {
            int mid = (i+j)/2;  // this step gave an error
            if(slidingWindowCheck(nums, target, mid)) {
                result = mid;
                j = mid -1;
            } else {
                i = mid + 1;
            }
        }
        return result;
    }
    
    // apply sliding window technique of partic
    private boolean slidingWindowCheck(int[] nums, int target, int len) {
        int sum = 0;
        for(int i = 0; i<len; i++) {
            sum += nums[i];
        }
        if(sum >= target) return true;
        
        for(int i=len;i<nums.length;i++) {
            sum -= nums[i-len];
            sum += nums[i];
            if(sum >= target) return true;
        }
        return false;
    }
    
}
```

### Approach - 2

- Time Complexity: O(N)
- Space Complexity: O(1)

```java

```