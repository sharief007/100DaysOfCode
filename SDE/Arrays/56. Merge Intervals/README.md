
[56. Merge Intervals](https://leetcode.com/problems/merge-intervals/)

### Approach 

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        for (int i = 0; i < n; i++) {
            int left = intervals[i][0], right = intervals[i][1];
            
            while (i + 1 < n && right >= intervals[i + 1][0]) {
                right = Math.max(right, intervals[i + 1][1]);
                i++;
            }
            
            ans.add(new int[] { left, right });
        }
        return ans.toArray(new int[0][0]);
    }
}
```