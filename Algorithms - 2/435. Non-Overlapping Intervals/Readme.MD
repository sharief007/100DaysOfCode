[435 Non-Overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/)

[Youtube Explanation](https://www.youtube.com/watch?v=nONCGxWoUfM&t=65s)

### Approach 

Time Complexity: O(nlogn)

Space Complexity: O(1)

```java
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[1]-b[1]);
        int prev = intervals[0][1], count = 0, n = intervals.length;
        for(int i=1;i<n;i++) {
            int start = intervals[i][0], end = intervals[i][1];
            if(start >= prev) {
                prev = end;
            } else {
                count++;
                prev = Math.min(prev, end);
            }
        }
        return count;
    }
}
```