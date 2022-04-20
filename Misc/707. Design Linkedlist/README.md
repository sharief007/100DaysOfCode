
[707. Design LinkedList]()

Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:

- MyLinkedList() Initializes the MyLinkedList object.
- int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
- void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
- void addAtTail(int val) Append a node of value val as the last element of the linked list.
- void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
- void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.

### Approach - 1 (Stolen)

Inserting and deleting at particular indices is difficult. (need to change head/rear values)

```java
class MyLinkedList {
    class Node{
        int val;
        Node next;
        
        Node(){}
        
        Node(int val){
            this.val = val;
        }
        
        Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }
    
    Node head;
    Node tail;
    int len = 0;
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new Node(0);
        tail = new Node(0);
        
        head.next = tail;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= len)
            return -1;
        
        Node curr = head.next;
        
        int ind = 0;
        
        while(curr != tail && ind != index){
            ind++;
            curr = curr.next;
        }
    
        return curr.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        
        newNode.next = head.next;
        head.next = newNode;
        
        len++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node newNode = new Node(0);
        
        tail.next = newNode;
        
        tail.val = val;
        
        tail = tail.next;
        
        len++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > len)
            return;
        
        if(index == 0)
            addAtHead(val);
        
        else if(index == len)
            addAtTail(val);
        
        else{
            Node curr = head.next;

            Node prev = head;

            int ind = 0;

            while(curr != null && ind != index){
                ind++;
                curr = curr.next;
                prev = prev.next;
            }

            Node newNode = new Node(val);

            newNode.next = prev.next;

            prev.next = newNode;

            len++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < len){
            Node prev = head;
            Node curr = head.next;
            int ind = 0;
            
            while(curr != tail && ind != index){
                ind++;
                curr = curr.next;
                prev = prev.next;
            }
            
            prev.next = prev.next.next;
            
            curr = null;
            
            len--;
        }
    }
}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
```