[11. Container With Most Water](https://leetcode.com/problems/container-with-most-water/)

### Approach - 1

- Time Complexity: O(N^2)
- Space Complexity: O(1)

```java
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        
        int maxCapacity = Integer.MIN_VALUE;
        
        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<n;j++) {
                int waterCapacity = (j-i) * Math.min(height[i], height[j]);
                maxCapacity = Math.max(maxCapacity, waterCapacity);
            }
        }
        return maxCapacity;
    }
}
```

### Approach - 2

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        
        int i = 0, j = n-1, maxCap = Integer.MIN_VALUE;
        
        while(i<j) {
            int waterCap = (j-i) * Math.min(height[i], height[j]);
            maxCap = Math.max(maxCap, waterCap);
            
            if(height[i] < height[j]) {
                i++;
            } else if(height[i] > height[j]) {
                j--;
            } else {
                i++;
                j--;
            }
        }
        return maxCap;
    }
}
```