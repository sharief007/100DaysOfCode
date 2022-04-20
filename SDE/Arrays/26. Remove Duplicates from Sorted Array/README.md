[26. Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)

### Approach (Two pointers)

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int start = 0;
        
        for(int i=1; i<nums.length; i++) {
            if(nums[i] != nums[start]) {
                start++;
                nums[start] = nums[i];
            }
        }
        return start + 1;
    }
}
```