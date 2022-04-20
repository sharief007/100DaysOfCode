
[75. Sort Colors](https://leetcode.com/problems/sort-colors/)

### Approach - 1 (Any sorting algorithm)

- Time Complexity: O(N * logN)
- Space Complexity: O(1)

### Approach - 2 (Counting Sort)

- Time Complexity: O(N)
- Space Complexity: O(1)

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

### Approach - 3 (3 pointer approach)

[Youtube Explanation](https://www.youtube.com/watch?v=sEQk8xgjx64)

- Time Complexity: O(N)
- Space Complexity: O(1)

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