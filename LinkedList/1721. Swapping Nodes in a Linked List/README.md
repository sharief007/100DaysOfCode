
[1721. Swapping Nodes in a Linked List](https://leetcode.com/problems/swapping-nodes-in-a-linked-list/)

You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).

![Example Image](https://assets.leetcode.com/uploads/2020/09/21/linked1.jpg)

```text
Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]
```

### Approach - 1 (Use array)

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode node = head;
        
        int n = 0;
        while(node != null) {
            n++;
            node = node.next;
        }
        
        int[] arr = new int[n];
        n =0;
        node = head;
        
        while(node != null) {
            arr[n] = node.val;
            n++;
            node = node.next;
        }
        
        int temp = arr[k-1];
        arr[k-1] = arr[n-k];
        arr[n-k] = temp;
        
        head = null;
        ListNode rear = head;
        
        for(int i: arr) {
            if(head == null) {
                head = rear = new ListNode(i);
            } else {
                rear.next = new ListNode(i);
                rear = rear.next;
            }
        }
        
        return head;
    }
}
```

### Approach - 2 (Efficient)

1. First we need to find kth and (n-k)th terms in order to swap them.
2. Take two pointers pointing to head of linkedlist.
3. move the second pointer to kth position/node. (copy the node reference)
4. now the first pointer is at starting and second pointer is at K. (difference between them is k)
5. start traversing the list using both the pointers until second pointer reaches end of list.
6. now the first pointer will be at (n-k)th position. (because the distance between them is k and right pointer is at n).
7. check whether k and(n-k)th are equal, if not swap them.

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode left = head, right = head, front = null, rear = null;
        int count =1;
        while(count !=k && right !=null) {
            right = right.next;
            count++;
        }
        front = right;
        while(left !=null && right !=null && right.next !=null) {
            left = left.next;
            right = right.next;
        }
        rear = left;
        if(front!=rear && front !=null) {
            int temp = front.val;
            front.val = rear.val;
            rear.val = temp;
        }
        return head;
    }
}
```

