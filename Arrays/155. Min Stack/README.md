
[155. Min Stack]()

### Approach - 1

[Youtube Explanation](https://www.youtube.com/watch?v=V09NfaGf2ao)

- Time Complexity: O(1) for all operations
- Space Complexity: O(2 * N))

```java
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    int min = Integer.MAX_VALUE;
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (min > val)
            min = val;
        minStack.push(min);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
        if (minStack.isEmpty()) 
            min = Integer.MAX_VALUE;
        else
            min = minStack.peek();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
```

### Approach - 2

- Time Complexity: O(1) for all operations
- Space complexity: O(N)

[Youtube Explanation](https://www.youtube.com/watch?v=V09NfaGf2ao)
[Geeks for Geeks](https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/)

```java
class MinStack {
    Deque<Long> stack = new LinkedList<>();
    long min = Long.MAX_VALUE;
    public MinStack() {   
    }
    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push(1l*val);
            min=val;
        } else if(val<getMin()) {
            stack.push((2l*val-min));
            min=val;
        } else {
            stack.push(1l*val);        
        }
    }
    
    public void pop() {
        long item = stack.pop();
        if(item<getMin()) {
            min = 2l*min-item;
        }
    }
    
    public int top() {
        long item = stack.peek();
        return (int)(item<getMin()?getMin():item);
    }
    
    public int getMin() {
        return (int)min;
    }
}
```