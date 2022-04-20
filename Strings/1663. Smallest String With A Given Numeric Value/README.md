[1663. Smallest String With A Given Numeric Value](https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/)

The numeric value of a lowercase character is defined as its position (1-indexed) in the alphabet, so the numeric value of a is 1, the numeric value of b is 2, the numeric value of c is 3, and so on.

The numeric value of a string consisting of lowercase characters is defined as the sum of its characters' numeric values. For example, the numeric value of the string "abe" is equal to 1 + 2 + 5 = 8.

You are given two integers n and k. Return the lexicographically smallest string with length equal to n and numeric value equal to k.

Note that a string x is lexicographically smaller than string y if x comes before y in dictionary order, that is, either x is a prefix of y, or if i is the first position such that x[i] != y[i], then x[i] comes before y[i] in alphabetic order.

```text
Input: n = 3, k = 27
Output: "aay"
Explanation: The numeric value of the string is 1 + 1 + 25 = 27, and it is the smallest string with such a value and length equal to 3.
```

### Approach

![Image](https://assets.leetcode.com/users/images/a05843fc-ad11-4189-9fe0-a451d9ef8cd0_1647910249.0571206.png)

[Leetcode Explanation](https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/discuss/1871662/JavaC%2B%2B-Easiest-Possible-Exaplained!!)

- Time Complexity: O(26 * N)
- Space Complexity: O(1) // ignoring answer

```java
class Solution {
    public String getSmallestString(int len, int sum) {
        
        char[] word = new char[len];
        Arrays.fill(word, 'a');
        
        int n = 25, remaining = sum - len;
        
        while(n > 0 && remaining > 0 && len > 0) {
            if(remaining >= n) {
                len--;
                char ch = (char) (n + 96 + 1);
                word[len] = ch;
                
                remaining -= n;
            } else {
                n--;
            }
        }
        return new String(word);        
    }
}
```