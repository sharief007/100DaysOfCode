import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void nextPermutation(int[] A) {
        if (A == null || A.length <= 1)
            return;
        int i = A.length - 2;
        while (i >= 0 && A[i] >= A[i + 1])
            i--;
        if (i >= 0) {
            int j = A.length - 1;
            while (A[j] <= A[i])
                j--;
            swap(A, i, j);
        }
        reverse(A, i + 1, A.length - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(int[] A, int i, int j) {
        while (i < j)
            swap(A, i++, j--);
    }
}
