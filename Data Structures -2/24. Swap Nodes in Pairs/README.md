
[24. Swap Nodes in pairs](https://leetcode.com/problems/swap-nodes-in-pairs/)

Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

![Example Image](https://assets.leetcode.com/uploads/2020/10/03/swap_ex1.jpg)

### Approach - 1

### Draw this unless you wont understand

- Time complexity: O(n)
- Space complexity: O(1)

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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode temp = head, rear = null;
        head = null;
        
        while(temp != null && temp.next != null) {
            ListNode third = temp.next.next;
            ListNode second = temp.next;
            
            temp.next = third;
            second.next = temp;
            
            if(rear != null) {
                rear.next = second;
            }
            rear = temp;
            
            temp = temp.next;
            if(head == null) {
                head = second;
            }
        }
        return head;
    }
}
```