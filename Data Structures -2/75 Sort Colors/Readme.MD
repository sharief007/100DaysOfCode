[75. Sort Colors](https://leetcode.com/problems/sort-colors/submissions/)

### Approach - 1

Time Complexity: O(n)
Space Complexity: O(1)

```java
class Solution {
    public void sortColors(int[] nums) {
        int one=0, two=0, three=0;
        for(int n:nums) {
            switch(n) {
                case 0: one++; break;
                case 1: two++; break;
                case 2: three++; break;
            }
        }
        for(int i=0;i<one;i++) nums[i] = 0;
        for(int j=one;j<one+two;j++) nums[j] =1;
        for(int k=one+two;k<one+two+three;k++) nums[k]=2;
    }
}
```

### Approach - 2
Use three pointers

Time Complexity: O(n)
Space COmplexity: O(1)

```java
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length, i = 0, mid = 0, j = n-1;
        while(mid<=j) {
            if(nums[mid] == 0) {
                swap(nums, i, mid);
                i++;
                mid++;
            } else if(nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, j);
                j--;
            }
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```