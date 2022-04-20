import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        // int[][] arr = {{1,10},{2,3},{4,5},{6,7},{8,9}};
        int[][] arr = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        System.out.println(Arrays.deepToString(merge2(arr)));
    }

    private static int[][] merge1(int[][] intervals) {
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

    private static int[][] merge2(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0, n = intervals.length;
        while (i < n) {
            while (i + 1 < n && intervals[i][1] < intervals[i + 1][0]) {
                ans.add(intervals[i]);
                i++;
            }
            int left = intervals[i][0], right = intervals[i][1];
            while (i + 1 < n && right >= intervals[i + 1][0]) {
                left = Math.min(left, intervals[i + 1][0]);
                right = Math.max(right, intervals[i + 1][1]);
                i++;
            }
            ans.add(new int[] { left, right });
            i++;
        }
        return ans.toArray(new int[0][0]);
    }
}
