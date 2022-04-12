
[287. Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/)

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

### Approach ()

[GitHub](https://github.com/sharief007/100DaysOfCode/tree/master/Misc/Medium/287.%20Find%20the%20Duplicate%20Number)

------------------ other solutions ------------------
 ### Approach (Modifing/Sorting Array)

 - Time Complexity: O(N*Logn)
 - Space Complexity: O(1)

```java
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        
        for(int i=0;i<n-1;i++) {
            if(nums[i] == nums[i+1]) return nums[i];
        }
        
        return -1;
    }
}
```
-----------

1. Since the array values ranges from 0-n, we can count the frequency of values using indexes.
2. Because all the values will be within n, so for a element with value 'v', use index nums[v].
3. For every occurance of a value, increase the index by array length, because we can retrieve the frequency by dividing with array length easily.

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        
        // use index number to store the frequency count
        for(int val : nums) {
            int idx = val % n;  
            nums[idx] += n; // for every occurance of val, increase nums[idx] by n
        }
        
        for(int i=0;i<n;i++) {
            int count = nums[i] / n;    // dividing the value with n, we will get frequency
            if(count >= 2) {
                return i;
            }
        }
        
        return -1;
    }
}
```

--------------

Mark visited values as negative. if you encounter negative value again thats the answer.

- Time Complexity: O(N)
- Space Complexity: O(1)

[Youtube Explanation](https://www.youtube.com/watch?v=dfIqLxAf-8s)

```java

```