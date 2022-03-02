
[42. Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/submissions/)


### Approach - 1 (brute force)

[Youtube Explanation](https://www.youtube.com/watch?v=m18Hntz4go8)

- Time Complexity: O(N^2)
- Space Complexity: O(1)

```java
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int sum = 0;
        for(int i=0;i<n;i++) {
            int left = Integer.MIN_VALUE, right = Integer.MIN_VALUE, ptr = i;
            while(ptr >= 0) {
                left = Math.max(left, height[ptr]);
                ptr--;
            }
            ptr = i;
            while(ptr <n) {
                right = Math.max(right, height[ptr]);
                ptr++;
            }
            sum += Math.min(left,right) - height[i];           
        }
        return sum;
    }
}
```

### Approach - 2 (Better)

Use prefix sum

[Youtube Explanation](https://www.youtube.com/watch?v=m18Hntz4go8)
- Time Complexity: O(N)
- Space Complexity: O(N)

```java
class Solution {
    public int trap(int[] height) {
        int n = height.length, sum = 0;
        int[] leftPrefix = new int[n], rightSuffix = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            max = Math.max(max, height[i]);
            leftPrefix[i] = max;
        }
        max = Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--) {
            max = Math.max(max, height[i]);
            rightSuffix[i] = max;
        }
    
        for(int i=0;i<n;i++) {
            sum+= Math.min(leftPrefix[i],rightSuffix[i]) - height[i];           
        }
        
        return sum;
    }
}
```

### Approach - 3 (Optimal)

- Time Complexity: O()
- Space Complexity: O()

```java

```