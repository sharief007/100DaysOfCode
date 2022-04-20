[2. Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

![Image](https://assets.leetcode.com/uploads/2020/10/02/addtwonumber1.jpg)

```
2+5 = 7
4+6 = 10 (sum = 0, carry = 1)
3+4 = 8 (7+ 1(carry) )

answer = 7 0 8
```

### Approach - 1

Time Complexity: O(N)

Space Complexity: O(1)

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            int a = (l1 == null)? 0: l1.val;
            int b = (l2 == null) ?0: l2.val;
            int sum = a + b + carry;
            carry = sum /10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
        }
        if (carry > 0) cur.next = new ListNode(1);
        return dummy.next;
    }
}
```