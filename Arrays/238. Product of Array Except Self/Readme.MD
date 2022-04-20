
[238. Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

### Idea

1. Find the product of all elements
2. divide the index element to find the value.

This approach wont work if zero's involved.

### Approach

Using Prefix Product.
[Youtube Explanation](https://www.youtube.com/watch?v=bNvIQI2wAjk)

- Define 2 arrays of same length.
- Fill first array with prefix product value from left
- Fill second array with prefix product value from right
- use these two arrays to find the value i.e, left[i-1] * right[i+1]. exclude current index.

Time Complexity: O(n)
Space Complexity: O(n)

```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n], suffix = new int[n];
        int[] ans = new int[n];
        for(int i=0;i<n;i++) {
            if(i==0) {
                prefix[i] = nums[i];
                suffix[n-i-1] = nums[n-i-1]; 
            } else {
                prefix[i] = prefix[i-1] * nums[i];
                suffix[n-i-1] = suffix[n-i] * nums[n-i-1];
            }
        }
        ans[0] = suffix[1];
        ans[n-1] = prefix[n-2];
        for(int i=1;i<n-1;i++) {
            ans[i] = prefix[i-1] * suffix[i+1];
        }
        return ans;
    }
}
```


### Approach -2

- Use the same approach, use two variables instead of two arrays.

Time Complexity: O(n)

Space Complexity: O(1)

```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length, temp = 1;
        
        int[] ans = new int[n];
        ans[0] = 1;
        for(int i=1;i<n;i++) {
            temp *= nums[i-1];
            ans[i] = temp;
        }
        temp = 1;
        for(int i=n-2;i>=0;i--) {
            temp *= nums[i+1];
            ans[i] *= temp;
        }
        return ans;
    }
}
```