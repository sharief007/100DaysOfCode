
[201. Bitwise AND of Numbers Range](https://leetcode.com/problems/bitwise-and-of-numbers-range/)

### Approach

[Youtube Explanation](https://www.youtube.com/watch?v=-qrpJykY2gE)

- Time Complexity: O(left-right)
- Space Complexity: O(1)

```java
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int and = left == 0 ? 1 : 0;
        
        for(int i = left; i<= right; i++) {
            and = and ^ i;
        }
        
        return and;
    }
}
```

### Approach - 2

- Time Complexity: O(1)
- Space Complexity: O(1)

```java
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int bits = 0;
        
        while(left != right) { // right shift untill both the numbers are equal
            left = left >> 1; // right shift by 1 bit
            right = right >> 1; // right shift by 1 bit
            bits++;     // no. of shifts till now
        }
        
        return right << bits; // or left << bits
    }
}
```