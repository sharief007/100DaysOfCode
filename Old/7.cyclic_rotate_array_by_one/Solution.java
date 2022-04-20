import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,0};
        rotate(arr);
        System.out.println(Arrays.toString(arr));
    }

    // private static void rotate(int[] arr,int k) {
    //     int n = arr.length;
    //     int sets = findGCD(k, n);
    //     for(int i=0;i<sets;i++) {
    //        int j = i, temp = arr[j];
    //        while (true) {
    //            int d = (j+k)%n;
    //            if(i==d) break;
    //            arr[j] = arr[d];
    //            j = d;
    //        }
    //        arr[j] = temp;
    //     }
    // }

    // private static int findGCD(int a, int b)   
    // {   
    //     if (b == 0)   
    //     return a;     
    //     return findGCD(b, a % b);   
    // }

    private static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void rotate(int[] arr) {
        int n = arr.length-1;
        for(int i=0; i!=n;i++) {
            swap(arr, i, n);
        }
    }

    private static void rotateByOne(int[] arr) {
        int n = arr.length;
        int last = arr[n-1];
        for(int i=n-1;i>=1;i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = last;
    }
}
