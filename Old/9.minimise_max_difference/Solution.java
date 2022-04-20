import java.util.Arrays;
public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 15, 10};
        int k = 6;
        System.out.println(getMinDiff(arr, arr.length, k));
    }

    static int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int ans = arr[n-1] - arr[0];
        int smallest = arr[0] + k, largest = arr[n-1]-k;
        for(int i = 0; i < n-1; i++){
            int min = Math.min(smallest, arr[i+1]-k);
            int max = Math.max(largest, arr[i]+k);
            if(min < 0) 
                continue;
            ans = Math.min(ans, max-min);
        }
        return ans;
    }
}
