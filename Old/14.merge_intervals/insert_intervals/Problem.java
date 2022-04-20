import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem {
    public static void main(String[] args) {
        // int[][] arr = {{1,3},{6,9}};
        // int[] a = {2,5};
        // int[][] arr = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        // int[] a = {4,8};
        int[][] arr = {{1,5}};
        int[] a = {5,7};
        System.out.println(Arrays.deepToString(insert(arr, a)));
    }
    

    public static int[][] insert(int[][] intervals, int[] newInterval) {
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

    
}
