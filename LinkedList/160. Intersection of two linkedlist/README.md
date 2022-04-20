[160. Intersection of two linkedlists](https://leetcode.com/problems/intersection-of-two-linked-lists/)

Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

For example, the following two linked lists begin to intersect at node c1:

![Sample Picture](https://assets.leetcode.com/uploads/2021/03/05/160_statement.png)

The test cases are generated such that there are no cycles anywhere in the entire linked structure.

Note that the linked lists must retain their original structure after the function returns.

### Approach - 1 (Using Set)

- Time Complexity : O(M+N)
- Space Complexity: O(M+N)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        
        ListNode temp1 = headA, temp2 = headB;
        ListNode ans = null;
        
        while(temp1 != null) {
            set.add(temp1);
            temp1 = temp1.next;
        }
        
        while(temp2 != null) {
            if(!set.add(temp2)) {
                ans = temp2;
                break;
            }
            temp2 = temp2.next;
        }
        
        return ans;        
    }
}
```


### Approach - 2 

- Time Complexity: O(M+N)
- Space Complexity: O(1)


```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA, temp2 = headB;

        while(temp1 != temp2) {
            temp1 = (temp1 == null) ? headA : temp1.next;
            temp2 = (temp2 == null) ? headB : temp2.next;
         }
        return temp1;
    }
}
```