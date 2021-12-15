import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {34,64,23,98,12,56,25};
        int l = largest(arr,4);
        int s = smallest(arr,4);
        System.out.println(String.format("%sth largest =%s\n%sth smallest =%s", 5,l,5,s));
    }

    private static int largest(int[] arr,int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int n: arr) queue.add(n);
        for(int i=0;i<arr.length-k;i++) queue.poll();
        System.out.println(queue);
        return queue.peek();
    }

    private static int smallest(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int n: arr) queue.add(n);
        for(int i=0;i<k-1;i++) queue.poll();
        return queue.peek();
    }

    /*private static int largest(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[arr.length-k];
    }

    private static int smallest(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[k-1];
    }*/
}
