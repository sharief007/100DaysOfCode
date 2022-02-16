
[143. Reorder List](https://leetcode.com/problems/reorder-list/)

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.


![Example Picture](https://assets.leetcode.com/uploads/2021/03/04/reorder1linked-list.jpg)

### Approach - 1

- Time Complexity: O(n)
- Space Complexity: O(1)

Merger function is difficult (draw it once and dry run it)
Edge cases are difficult.


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
    public void reorderList(ListNode head) {
        
        ListNode fast = head, slow = head;
        
        //find the centre of the list
        ListNode prev = null;
        while(slow != null && fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow pointer refers to the first element of second half
        // we need break connection between fist half ans second half

        if(prev != null) { // if list has only 1 element then prev will be null
            prev.next = null;
        }
        
        //reverse the second half of the linked list
        ListNode second = reverseLinkedList(slow);
        ListNode first = head;

        //check there is only one element, then fast and slow will be same node
        if(first==second) return;
        merger(first, second);
    }
    
    
    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev= null, curr = head;
        
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    
    private void print(ListNode head) {
        ListNode temp = head;
        while(temp != null) {
            System.out.printf("%s ",temp.val);
            temp = temp.next;
        }
        System.out.println("");
    }
    
    private void merger(ListNode head1, ListNode head2) {
        while(head2 != null) {
            if(head1==null) break;
            
            ListNode next1 = head1.next;
            ListNode next2 = head2.next;
            
            
            head1.next = head2;

            // this break is important
            // dry run this shit to understand
            if(next1 == null) break;


            head2.next = next1;
            
            head1 = next1;
            head2 = next2;
            
            
        }
    }
    
}
```