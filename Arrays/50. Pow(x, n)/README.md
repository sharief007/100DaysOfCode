
[50. Pow(x, n)](https://leetcode.com/problems/powx-n/)

### Approach (east than it looks)

[Youtube Explanation](https://www.youtube.com/watch?v=l0YC3876qxg)

- Time Complexity: O(Log N)
- Space Complexity: O(1)

```java
class Solution {
    public double myPow(double x, int n) {
        double res = 1.0;
        long p = n;     // when converting last -ve int value to +ve. it exceeds the range
        boolean inverse = false;
        
        if(p < 0) {
            inverse = true;
            p *= -1;
        }
        
        while(p > 0) {
            if(p %2 == 0) { // divide the pow by 2, square the base 
                x *= x;   // sqaure the base i.e multiply it with itself
                p /= 2;
            } else {
                res *= x; 
                p -= 1;
            }
            // System.out.println(p);
        }
        
        return inverse ? 1/res : res;
    }
}
```