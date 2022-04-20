
[34. Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

### Approach 

- Time Complexity: O(logN)
- Space Complexity: O(1)

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i = findFirstIndex(nums,target);
        int j = findLastIndex(nums,target);
        return new int[]{i,j};
    }
    
    private int findFirstIndex(int[] nums, int target) {
        int n = nums.length, i = 0, j= n-1;
        int index = n;
        while(i<=j) {
            int mid = i+(j-i)/2;
            if(nums[mid]<target) {
                i = mid + 1;
            } else if(nums[mid]>target){
                j = mid - 1;
            } else {
                index = Math.min(index,mid);
                j = mid -1;
            }
        }
        return index==n?-1:index;
    }
    
    private int findLastIndex(int[] nums, int target) {
        int n = nums.length, i = 0, j= n-1;
        int index = -1;
        while(i<=j) {
            int mid = i + (j-i)/2;
            if(nums[mid]<target) {
                i = mid + 1;
            } else if(nums[mid]>target){
                j = mid - 1;
            } else {
                index = Math.max(index,mid);
                i = mid+1;
            }
        }
        return index;
    }
    
}
```