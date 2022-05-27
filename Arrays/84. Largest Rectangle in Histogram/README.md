[84. Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/)

![Sample Image](https://assets.leetcode.com/uploads/2021/01/04/histogram.jpg)
![Sample Image](https://assets.leetcode.com/uploads/2021/01/04/histogram.jpg)

### Approach - 1 (Brute Force)

[Youtube Explanation](https://www.youtube.com/watch?v=vcv3REtIvEo&t=1010s)

The Idea is that, In every max rectangle, there will be atleast one bar completely included.
so for each bar in the graph, find the total area that could be formed and derive the max area.

- Time Complexity: O(N^2)   => TLE (93/98)
- Space Complexity: O(1)

```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        
        int result = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++) {
            int val = heights[i];
            int width = 1, j = i -1;
            
            while( j>=0 && heights[j] >= val) {
                j--;
                width++;
            }
            
            j = i+1;
            
            while( j<n && heights[j] >= val) {
                j++;
                width++;
            }
            
            int area = val * width;
            result = Math.max(result, area);
        }
        return result;
    }
}
```

### Approach - 2

[Youtube Explanation](https://www.youtube.com/watch?v=vcv3REtIvEo&t=1010s)

Finding the left limit and right limit is taking O(N) time in above approach. we need to reduce that.

Left limit can be found using prev smaller element. This can be done using stack.
Right limit can be found using next smaller element. This can be done using stack.

width at a particular bar will be, width = right - left + 1;

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        
        int result = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        
        int[] left = new int[n], right = new int[n];
        
        
        for(int i=0;i<n;i++) {
            int currHeight = heights[i];
            while(!stack.isEmpty() && heights[stack.peek()] >= currHeight ) {
                stack.pop();
            }
            
            left[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }
        
        stack.clear();
        
        for(int i=n-1;i>=0;i--) {
            int currHeight = heights[i];
            
            while(!stack.isEmpty() && heights[stack.peek()] >= currHeight ) {
                stack.pop();
            }
            
            right[i] = stack.isEmpty() ? n-1 : stack.peek() -1;
            stack.push(i);
        }
        
        for(int i=0;i<n;i++) {
            int width = right[i] - left[i] + 1;
            int area = width * heights[i];
            result = Math.max(area, result);
        }
        
        return result;
    }
}
```