[25. Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/)

Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

![Image](https://assets.leetcode.com/uploads/2020/10/03/reverse_ex1.jpg)

### Approach -1 (Brute force)

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
    public ListNode reverseKGroup(ListNode head, int k) {
       
	    ListNode temp = head;
        List<Integer> data = new ArrayList<>();
        
        while(temp != null) {
            data.add(temp.val);
            temp = temp.next;
        }
                
        List<List<Integer>> partitions = new ArrayList<>();
		
		// Create partitions of size k or less 
        for (int i = 0; i < data.size(); i += k) {
            partitions.add(data.subList(i, Math.min(i + k, data.size())));
        }
        
        temp = head;

        for (List<Integer> list : partitions) {
		    // Reverse the equal parted lists 
            if (list.size() == k) Collections.reverse(list);
			// Create a new link list with our sorted data
            for(Integer item: list) {
                temp.next = new ListNode(item);
                temp = temp.next;
            }
        }
        
        return head.next;
    }
}
```

### Approach - 2 (Using a stack)

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
            rear.next = head;     // point to remaining elements
        }
        return front;
    }
}
```

### Approach - 3 (Optimal)

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 0 || k == 1) {
            return head;
        }
        
        int count = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode tail = dummy;
        ListNode ptr = head;
        
        while(ptr != null) {
            count = 0;
            ListNode currHead = ptr;
            while(ptr != null && count != k) {
                count++;
                ptr = ptr.next;
            }
            if (count < k) {
                tail.next = currHead;
                break;
            }
            ptr = currHead;
            ListNode n = null;
            ListNode prev = null;
            count = 0;
            while(ptr != null && count != k) {
                n = ptr.next;
                ptr.next = prev;
                prev = ptr;
                ptr = n;
                count++;
            }
            tail.next = prev;
            tail = currHead;
            tail.next = null;
        }
        
        return dummy.next;
        
    }
}
```