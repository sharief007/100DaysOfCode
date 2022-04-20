import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {0,2,1,2,0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //traverse the array and count 0s, 1s, 2s
    private static void sortByCount(int[] arr) {
        int zeros = 0, ones =0, twos =0;
        for(int i:arr) {
            switch(i) {
                case 0: zeros++; break;
                case 1: ones++; break;
                case 2: twos++; break;
            }
        }
        for(int i=0;i<zeros;i++) arr[i] = 0;
        for(int i=zeros;i<(zeros+ones);i++) arr[i] = 1;
        for(int i=zeros+ones;i<zeros+ones+twos;i++) arr[i] = 2;
    }

    // since we have only 3 distinct elements in array
    // use 3 pointers approach
    private static void sort(int[] arr) {
        int i =0, mid =0, j = arr.length - 1;
        while(mid<=j) {
            switch (arr[mid]) {
                case 0: swap(arr,i,mid);
                    i++; mid++; break;
                case 1: mid++; break;
                case 2: swap(arr, mid, j);
                    mid++; j--; break;
            }
        }
    }

    private static void swap(int[] arr,int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
