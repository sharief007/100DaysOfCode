public class Solution {
    public static void main(String[] args) {
        int[] arr= {-1,-2,-3,-4,5};
        System.out.println(largestSum(arr));
    }

    private static int largestSum(int[] arr) {
        int sum = 0, max = Integer.MIN_VALUE;
        for(int i:arr) {
            sum += i;
            max = Math.max(sum, max);
            if (sum<0) {
                sum =0;
            }
        }
        return max;
    }
}
