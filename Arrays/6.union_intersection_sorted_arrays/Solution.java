import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] a = {1,1,2,3,4,5,6};
        int[] b = {2, 3, 4, 5};
        System.out.println(String.format("Union =%s",Arrays.toString(union(a, b))));
        System.out.println(String.format("Intersection =%s", Arrays.toString(intersection(a,b))));
    }

    private static int[] union(int[] a,int[] b) {
        int n = a.length, m = b.length, i = 0, j= 0;
        //init an array of size n+m (resultant array)
        //else use a set data structure to store unique values
        int[] arr = new int[n+m];
        int index = 0;
        while(i<n && j<m) {
            if(a[i]<b[j]) {
                arr[index] = a[i];
                do {
                    i++;
                } while (i<n && a[i-1]==a[i]);
            } else if(a[i]>b[j]) {
                arr[index] = b[j];
                do {
                    j++;
                } while (j<m && b[j-1]==b[j]);
            } else if(a[i]==b[j]){
                arr[index] = a[i];
                do {
                    i++;
                } while (i<n && a[i-1]==a[i]);
                do {
                    j++;
                } while (j <m && b[j-1]==b[j]);
            }
            index++;
        }
        for(;i<n;i++) {
            arr[index] = a[i];
            index++;
        }
        for(;j<m;j++) {
            arr[index] = b[j];
            index++;
        }
        return arr;
    }

    private static int[] intersection(int[] a,int[] b) {
        int n = a.length, m = b.length;
        int[] arr = new int[Math.max(n,m)];
        int i=0,j =0, index =0;
        while(i<n && j<m) {
            if(a[i]<b[j]) {
                do {
                    i++;
                } while (i<n && a[i-1]==a[i]);
            }
            else if(a[i]>b[j]) {
                do {
                    j++;
                } while(j<m && b[j-1]==b[j]);
            }
            else if(a[i]==b[j]) {
                arr[index] = a[i];
                index++;
                do {
                    i++;
                } while (i<n && a[i-1]==a[i]);
                do {
                    j++;
                } while(j<m && b[j-1]==b[j]);
            }
        }
        return arr;
    }
}
