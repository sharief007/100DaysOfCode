public class Solution {
    public static void main(String[] args) {
        // int[] arr = {1,3,5,8,9,2,6,7,6,8,9};
        int[] arr = {1,4,3,2,6,7};
        System.out.println(minJumps(arr));
    }

    private static int minJumps(int[] arr) {
        int count = 0;
        for(int i=0;i<arr.length;) {
            int temp = i;
            i = i + arr[i] -1;
            if(temp==i) {
                i++;
                count--;
            }
            count++;
        }
        return count;
    }
}
