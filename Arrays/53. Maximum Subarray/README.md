
[53. Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)

```text
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
```

### Approach - 1 (Brute force) 

- Time Complexity: O(N^2) ~ Time Limit Exceeded.
- Space Complexity: O(1)

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length, maxVal = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++) {
            int sum = 0;
            for(int j=i;j<n;j++) {
                sum += nums[j];
                maxVal = Math.max(maxVal, sum);
            }
        }
        return maxVal;
    }
}
```

### Approach - 2 (Sliding Window) 

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
public class Solution {
    public int maxSubArray(int[] nums) {
        int currentMax = nums[0];
        int globalMax = nums[0];
        
        for(int i = 1; i < nums.length; i++)
        {
			// we keep track of the current maximum and if we hit an element that is greater than the current maximum,
			// we reset the current max
            currentMax = Math.max(nums[i], currentMax + nums[i]);
			
			// check for global max update every iteration, incase currentMax is greater. 
            globalMax = Math.max(globalMax, currentMax);
        }
        return globalMax;
    }
}
```

### Approach - 2 (Kadane's Algorithm)

- Time Complexity: O(N)
- Space Complexity: O(1)

Works only for +ve values

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for(int i:nums) {
            sum += i;
            max = Math.max(sum,max);
            if(sum<0) sum = 0;
        }
        return max;
    }
}
```

#### Modified Kadane's Algorithm

- Time Complexity: O(N)
- Space Complexity: O(1)

works for both +ve/-ve values

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for(int i:nums) {
            sum += i;
            if(sum < i) sum = i;
            max = Math.max(sum,max);
        }
        return max;
    }
}
```