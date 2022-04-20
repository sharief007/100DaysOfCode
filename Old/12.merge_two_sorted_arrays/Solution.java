import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[] a = {7, 9,9, 10, 11, 11, 13, 14, 17 ,19};
        int[] b = {1, 1, 4, 5, 8, 11, 13, 16, 19, 19};
        merge(a, b, a.length, b.length);
        System.out.print(Arrays.toString(a));
        System.out.print(Arrays.toString(b));
    }

    public static void merge(int arr1[], int arr2[], int n, int m) {
        // code here
        int mid = (n+m/2) + (n+m)%2;
        while(mid>=1) {
            int p1 =0, p2 =mid;
            while(p1<n+m && p2<n+m) {
                int left = p1<n ? arr1[p1] : arr2[p1-n];
                int right = p2<n ? arr1[p2] : arr2[p2-n];
                if(left>right) {
                    swap(arr1,arr2,p1,p2,n);
                } 
                p1++;
                p2++;
            }
            if(mid==1) break;
            mid = (mid/2) + (mid%2);
        }
    }
    
    private static void swap(int[] a,int[] b,int p1,int p2, int n) {
        int temp;
        if(p1<n && p2<n) {
            temp = a[p1];
            a[p1] = a[p2];
            a[p2] = temp;
        } else if (p1>=n && p2 >=n) {
            p1 -= n;
            p2 -=n;
            temp = b[p1];
            b[p1] = b[p2];
            b[p2] = temp;
        } else if (p1<n && p2>=n) {
            p2 = p2 -n;
            temp = a[p1];
            a[p1] = b[p2];
            b[p2] = temp;
        } else if(p1>=n && p2 < n) {
            p1 -= n;
            temp = a[p1];
            a[p1] = b[p2];
            b[p2] = temp;
        }
    }

    // This method uses priority queue.
    // whenever we poll a element from priority queue, it will return the smallest element in the queue
    private static void mergePQ(int[] a, int[] b, int n, int m) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i: a) {
            pq.add(i);
        }
        for(int i:b) {
            pq.add(i);
        }
        for(int i=0;i<n;i++) {
            a[i] = pq.poll();
        }
        for(int i=0;i<m;i++) {
            b[i] = pq.poll();
        }
    }

    private static void merge1(int[] a, int[] b, int n, int m) {
        for(int i=0;i<n;i++) {
            if(a[i]>b[0]) {
                swap(a, b, i, 0);
                sort(b);
            }
        }
    }

    private static void sort(int[] arr) {
        for(int i=0;i<arr.length-1;i++) {
            if(arr[i]>arr[i+1]) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
    } 

    private static void swap(int[] a,int[] b,int i,int j) {
        int temp = a[i];
        a[i] = b[j];
        b[j] = temp;
    }
}
