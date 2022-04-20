
[81. Search in Rotated Sorted Array II](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/)

There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

You must decrease the overall operation steps as much as possible.

### Approach

- Time Complexity: O(LogN)
- Space Complexity: O(LogN)

```java
class Solution {
    public boolean search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }
    
    private boolean binarySearch(int arr[], int l, int h, int key)
    {
        if (l > h)
            return false;
     
        int mid = l + (h - l) / 2;
        if (arr[mid] == key)
            return true;
     
        // The tricky case, just update left and right
        if ((arr[l] == arr[mid])
            && (arr[h] == arr[mid]))
        {
            l++;
            h--;
              return binarySearch(arr,l,h,key);
        }
     
        // If arr[l...mid] is sorted
        else if (arr[l] <= arr[mid])
        {
     
            // As this subarray is sorted, we can quickly
            // check if key lies in any of the halves
            if (key >= arr[l] && key <= arr[mid])
                return binarySearch(arr, l, mid - 1, key);
     
            // If key does not lie in the first half
            // subarray then divide the other half
            // into two subarrays such that we can
            // quickly check if key lies in the other half
            else
              return binarySearch(arr, mid + 1, h, key);
        }
     
        // If arr[l..mid] first subarray is not sorted
        // then arr[mid... h] must be sorted subarray
           else  if (key >= arr[mid] && key <= arr[h])
            return binarySearch(arr, mid + 1, h, key);
     
        return binarySearch(arr, l, mid - 1, key);
    }
}
```