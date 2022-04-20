[45. Reverse Nodes]()

Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

![Example Picture](https://assets.leetcode.com/uploads/2020/10/03/reverse_ex1.jpg)

### Approach - 1 (Mine)

#### Draw this problem unless u wont understand

- Time Complexity: O(n)
- Space Complexity: O(n)

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
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        int n = 0;
        ListNode front = null, rear = null;
        while(head != null) {
            n = k;
            while(n>0 && head != null) {
                stack.push(head);
                head = head.next;
                n--;
            }
            
            if(n != 0) {
                break;
            }
            
            while(stack.size() > 0) {
                ListNode top = stack.pop();
                
                if(front == null) {
                    front = rear = top;
                } else {
                    rear.next = top;
                    rear = rear.next;
                }                
            }
            rear.next = head;
        }
        return front;
    }
}
```


### Approach - 2

- Time complexity: O(n)
- Space Complexity: O(1)

```java
public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = dummy , nex = dummy, pre = dummy;
        int count = 0;

        while(cur.next != null){
            cur = cur.next;
            count++;
        }

        while(count >= k){
            cur = pre.next;
            nex = cur.next;
            for(int i = 1; i < k; i++){
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
            pre = cur;
            count -=k;
        }
        return dummy.next;
    }
}
```