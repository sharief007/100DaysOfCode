
[31. Next Permutation](https://leetcode.com/problems/next-permutation/)

```text
Input: nums = [1,2,3]
Output: [1,3,2]
```

### Approach 

[Youtube Explanation](https://www.youtube.com/watch?v=LuLCLgMElus&t=4s)

[Youtube Explanation](https://www.youtube.com/watch?v=6qXO72FkqwM)

- Time Complexity: O(N)
- Space COmplexity: O(1)

```java
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        
        if(n==1) return;
        
        int i = n-2;
        
        while(i >= 0 && nums[i] >= nums[i+1]) i--;
        
        if(i >= 0 ) {
            int j = n-1;
            while(j>i && nums[j] <= nums[i]) j--;
            swap(nums, i , j);
        }
        // if i less than 0, then arr is sorted in desc order.
        reverse(nums, i+1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int i) {
        int j = nums.length - 1;
        
        while(i<=j) {
            swap(nums, i , j);
            i++;
            j--;
        }
    }
    
}
```