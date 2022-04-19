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

1. We need to break the linkedlist into multiple parts, each of size k. Each part will contain k nodes.
2. Take one ptr temp pointing to head
3. check whether there exists k nodes further or not.
4. If next k nodes exists, then we are reversing these k nodes
5. Else the remaining node (less than k) should not be reversed.


- Time Complexity: O(N)
- Space Complexity: O(1)

```java

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = null, rear = null;
        
        ListNode temp = head;

        while(temp != null) {
            // check whether there exists next k nodes or not.
            if(checkNextKNodes(temp, k)) {
                // reverse k elements
                ListNode[] reverse = reverseKNodes(temp, k);
                
                ListNode rev = reverse[0];  // head of linked list after reversing
                temp = reverse[1];          // head of next part of original linkedlist
                
                if(newHead == null) {
                    newHead = rear = rev;

                    while(rear.next != null) {  // we are not adding one node. we are adding multiple nodes.
                        rear = rear.next;       // go to the end of new list
                    }
                } else {
                    rear.next = rev;
                    while(rear.next != null) {  // we are not adding one node. we are adding multiple nodes.
                        rear = rear.next;       // go to the end of new list
                    }
                }
            } // remaining nodes are less than k. so no need to reverse these nodes 
            else {
                // check if new linkedlist is empty
                if(newHead == null) {
                    newHead = rear = temp;
                } else {    // is the list is not empty, update the rear pointer.
                    rear.next = temp;
                    //rear = rear.next;  //this step is not required. we are not adding one node. we are adding many nodes.
                }
                // Else block will be executed only once at last iteration
                // since we have already added the remaining elements to new list, we should mark temp as null
                temp = null;    
            }
        }
        return newHead;
    }
    
    // simple counting function
    private boolean checkNextKNodes(ListNode head, int k) {
        int count = 0;
        ListNode node = head;
        
        while(node != null && count != k) {
            count += 1;
            node = node.next;
        } 
        
        return count == k;
    }
    
    // simple reversal function
    private ListNode[] reverseKNodes(ListNode head, int k) {
        int count = 0;
        ListNode node = head, prev = null;
        
        while(node != null && count != k) {
            ListNode nex = node.next;
            node.next = prev;
            
            prev = node;
            node = nex;
            count++;    // this step is important
        }
        
        return new ListNode[] {prev, node};
    }
    
    private void print(ListNode head) {
        ListNode node = head;
        
        while(node != null) {
            System.out.printf("%s ->", node.val);
            node = node.next;
        }
        System.out.println("");
    }
}
```