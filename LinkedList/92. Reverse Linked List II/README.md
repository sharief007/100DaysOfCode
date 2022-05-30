[92. Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii/)

Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

![Image sample](https://assets.leetcode.com/uploads/2021/02/19/rev2ex2.jpg)

### Approach - 1 (Complete the task in one pass)

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;
        
        // divide the list into 3 parts i.e left, middle, right
        // middle part needs to be reversed.
        
        int ptr = 1;
        ListNode node = head, leftEnd = null;
        
        // find the last node of left part
        while(ptr != left) {
            leftEnd = node;
            node = node.next;
            ptr++;
        }
        
        // this is the first node of middle part
        ListNode curr = node;
        
        // if middle part starts from 1, there will be no left part
        if(leftEnd != null) {
            // if there exists left part, then break the link between left and middle
            leftEnd.next = null;
        }
        
        // start reversing the middle part
        ListNode prev = null;
        
        // dont reverse the whole list, stop when ptr reaches right 
        while( curr != null && ptr != right+1) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            
            ptr++;
        }
        
        // if left part exists, then link the left part and reversed middle part
        if(leftEnd != null) {
            leftEnd.next = prev;
        } 
        // if left part doesnt exist, reversed middle part will be new head
        else {
            head = prev;
        }
        
        // link the middle end to the right start
        if(node != null) {
            node.next = curr;
        }
        
        return head;
    }
}
```