import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        
        System.out.println(findMinMax(arr));
    }

    private static class MinMax {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        public String toString() {
            return String.format("Min = %s, Max = %s", min, max);
        }
    }

    //Recurise approach
    /*  if array_size = 1
            return element as both max and min
        else if arry_size = 2
            one comparison to determine max and min
            return that pair
        else     array_size  > 2 
            recur for max and min of left half
            recur for max and min of right half
            one comparison determines true max of the two candidates
            one comparison determines true min of the two candidates
            return the pair of max and min      */
    private static MinMax findMinMaxByRecursion(int[] arr, int i, int j) {
        MinMax obj =  new MinMax();
        switch (i-j) {
            // if the array contains only one element
            //i.e both the indexes will be same
            case 0: { 
                obj.min = obj.max = arr[i];
                return obj;
            }
            //if the array contains two elements
            //i.e both indexes are consecutive
            case 1: case -1: {
                obj.min = Math.min(arr[i], arr[j]);
                obj.max = Math.max(arr[i], arr[j]);
                return obj;
            }
            default : {
                int mid = (i+j)/2;
                MinMax left = findMinMaxByRecursion(arr, i, mid);
                MinMax right = findMinMaxByRecursion(arr, mid+1, j);
                obj.min = Math.min(left.min, right.min);
                obj.max = Math.max(left.max, right.max);
            }
        }
        return obj;
    }

    private static MinMax findMinMax(int[] arr) {
        MinMax obj = new MinMax();
        int n = arr.length;
        for(int i=0;i<n;i++)  {
            if(obj.min > arr[i]) obj.min = arr[i];
            if(obj.max < arr[i]) obj.max = arr[i];
        }
        return obj;
    }

    private static MinMax findMinMaxBySort(int[] arr) {
        //Sort the array in ascending order
        //first element will be the smallest
        //last element will be the largest
        MinMax obj =  new MinMax();
        Arrays.sort(arr);
        obj.min = arr[0];
        obj.max = arr[arr.length-1];
        return obj;
    } 
}
