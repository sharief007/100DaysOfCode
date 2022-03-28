
[202. Happy Number](https://leetcode.com/problems/happy-number/)

Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

```text
Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
```
### Approach (Recursion) - Mine

- This example takes extra space

```java
class Solution {
    
    Set<Integer> hashset = new HashSet<>();
    
    public boolean isHappy(int n) {
        if(n == 1) return true;
        
        // System.out.printf("%s %s\n", prev, n);
        if(!hashset.add(n)) return false;
        
        int sum = 0;
        
        while(n > 0) {
            int digit = n%10;
            sum += Math.pow(digit, 2);
            n /= 10;
        }
        
        return isHappy(sum);
    }
}
```

### Approach - 2 (Use slow & fast pointers)

```java
class Solution {
    
    Set<Integer> hashset = new HashSet<>();
    
    public boolean isHappy(int n) {
        int slowPtr = n, fastPtr = n;
        while( true ) {
            slowPtr = this.getSquareSum(slowPtr); // use slowPtr not 'n'
            fastPtr = this.getSquareSum(this.getSquareSum(fastPtr)); // use fastPtr not 'n'
            
            if(slowPtr == fastPtr) break;   // if repetition found, break the loop
        }
        return slowPtr == 1;
    }
    
    private int getSquareSum(int n) {
        int sum = 0;
        
        while(n>0) {
            sum += Math.pow( n%10, 2);
            n /= 10;
        }
        return sum;
    }
}
```