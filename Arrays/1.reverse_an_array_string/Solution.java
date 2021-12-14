import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        String str = "GITHUB.COM";
        
        reverseArray(arr);
        str = reverseString(str);
        System.out.println(Arrays.toString(arr));
        System.out.println(str);
    }

    //Reverse an array
    private static void reverseArray(int[] arr) {
        //use two pointers one at start and one at end of array
        //start swapping the elements from both sides
        // this loop will run for "length/2" times. 
        int i=0, j= arr.length-1;
        while(i<j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    //Reverse a string
    private static String reverseString(String str) {
        //use two pointers one at start and one at end of string
        //start swapping the elements from both sides
        // this loop will run for "length/2" times.
        int i=0, j = str.length()-1;
        while(i<j) {
          str = swap(str, i, j);
          i++;
          j--;
        }
        return str;
    }


    private static void swap(int[] arr,int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static String swap(String str, int i, int j)
    {
        char a = str.charAt(i), b = str.charAt(j);
        if (j == str.length() - 1) {
            return str.substring(0, i) + b
                + str.substring(i + 1, j) + a;
        }
  
        return str.substring(0, i) + b
            + str.substring(i + 1, j) + a
            + str.substring(j + 1, str.length());
    }
}