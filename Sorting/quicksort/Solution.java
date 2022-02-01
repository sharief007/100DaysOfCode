import java.util.*;

class Solution
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    {
        // code here
        if(low<high) {
            int p = partition(arr,low,high+1);
            quickSort(arr,low,p);
            quickSort(arr,p+1,high);
        }
    }
    static int partition(int arr[], int low, int high)
    {
        // your code here
        int i = low, j = high, pivot = low;
        while(i<j) {
            do {
                i++;
            } while(i<high && arr[i] <= arr[pivot]);
            do {
               j--; 
            } while(j>low && arr[j] > arr[pivot]);
            if(i<j) {
                swap(arr,i,j);
            }
        }
        swap(arr,pivot,j);
        return j;
    } 
    
    static void swap(int arr[],int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // int[] arr = new int[]{5,6,4,7,3,8,2,9,1,0};
        int[] arr = new int[]{10,1,2,3,4,5,6,7,8,9};
        Solution.quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}