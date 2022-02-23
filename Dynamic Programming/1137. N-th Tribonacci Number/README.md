
[1137. N-th Tribonacci Number](https://leetcode.com/problems/n-th-tribonacci-number/)

### Approach - 1

- Time Complexity: O(3 ^ N)
- Space Complexity: O(N) (Auxiliary space)

Time limit Exceeded

```java
class Solution {
    public int tribonacci(int n) {
        if(n==0) return n;
        if(n <= 2) return 1;
        return tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);   
    }
}
```

### Approach - 2

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
class Solution {
    public int tribonacci(int n) {
       HashMap<Integer,Integer> map = new HashMap<>();
       return nTribonacci(n,map);
    }
    
    public int nTribonacci(int n, Map<Integer,Integer> map) {
        if(map.containsKey(n)) return map.get(n);
        if(n==0) return 0;
        if(n<=2) return 1;
        int tri = nTribonacci(n-1,map) + nTribonacci(n-2,map) + nTribonacci(n-3,map);
        map.put(n,tri);
        return map.get(n);
    }
}
```