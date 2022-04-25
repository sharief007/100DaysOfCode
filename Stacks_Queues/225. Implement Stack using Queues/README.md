[225. Implement Stack using Queues](https://leetcode.com/problems/implement-stack-using-queues/)

### Approach

- TC push: O(N)
- TC pop: O(1)
- SC : O(N)

```java
class MyStack {

    private Queue<Integer> q1, q2;
    private int count;
    
    public MyStack() {
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
        count = 0;
    }
    
    public void push(int x) {
        count++;
        
        q2.add(x);
        
        while(q1.size() > 0) {
            q2.add(q1.peek());
            q1.remove();
        }
        
        //swap queues
        var temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    public int pop() {
        if(count > 0) {
            count--;
            return q1.remove();
        }
        return -1;
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return count <= 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
```