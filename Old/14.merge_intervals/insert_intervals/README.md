

```java
public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int i=0, n= intervals.length;
        while(i<n && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i]);
            i++;
        }
        int left = newInterval[0], right = newInterval[1];
        while(i<n && intervals[i][0] <= right) {
            left = Math.min(left,intervals[i][0]);
            right = Math.max(right,intervals[i][1]);
            i++;
        }
        ans.add(new int[]{left,right});
        while(i<n) {
            ans.add(intervals[i]);
            i++;
        }
        
        return ans.toArray(new int[0][0]);
    }
```