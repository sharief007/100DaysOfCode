[509. Fibonacci Number](https://leetcode.com/problems/fibonacci-number/)

### Approach - 1

- Time Complexity: O(2 ^ N)
- Space Complexity: O(N) (auxiliary stack space)

```java
class Solution {
    public int fib(int n) {
        if(n<=1) return n;
        return fib(n-1) + fib(n-2);
    }
}
```

### Approach - 2
(Using HashMap for caching)

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
class Solution {
    public int fib(int n) {
        return fibonacci(n, new HashMap<>());
    }
    
    private int fibonacci(int n, Map<Integer,Integer> map) {
        if(map.containsKey(n)) return map.get(n);
        
        if(n <= 1) return n;
        
        int fib =  fibonacci(n-1, map) + fibonacci(n-2, map);
        map.put(n, fib);
        return fib;
    }
}
```