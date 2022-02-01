[56. Merge Intervals](https://leetcode.com/problems/merge-intervals/)

### Approach - 1

1. Add all intervals to result until a overlap is found.
2. once overlap is found, reach to the end of the overlap, checking left and right elements
3. add the resultant interval to the result.
4. repeat 1,2,3 steps until i reaches end of array.

Time complexity: O(n)
Space complexity: O(1)

```java
class Solution {
    public int[][] merge(int[][] intervals) {
        int i = 0, n = intervals.length;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        List<int[]> list = new LinkedList<>();
        while(i< n) {
            while( i+1 < n && intervals[i][1]< intervals[i+1][0]) {
                list.add(intervals[i]);
                i++;
            }
            int left = intervals[i][0], right = intervals[i][1];
            
            while(i+1 <n && right >= intervals[i+1][0]) {
                left = Math.min(left, intervals[i+1][0]);
                right = Math.max(right, intervals[i+1][1]);
                i++;
            }
            list.add(new int[]{left,right});
            i++;
        }
        return list.toArray(new int[0][0]);
    }
}
```