import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {6,1,-2,3,-1,4,-3,-10,-9,-8};
        moveNegativeElements(arr);
        System.out.println(Arrays.toString(arr));
    }

    // Use two pointer approach
    private static void moveNegativeElements(int[] arr) {
        int i=0, j = arr.length-1;
        while(i<j) {
            if(arr[i]<0 && arr[j]<0) {
                i++;
            }
            else if(arr[i]>0 && arr[j]>0) {
                j--;
            } else if(arr[i]>0 && arr[j]<0) {
                swap(arr, i, j);
                i++;
            } else if(arr[i]<0 && arr[j]>0) {
                j--;
                i++;
            }
        }
    }

    private static void swap(int[] arr,int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
