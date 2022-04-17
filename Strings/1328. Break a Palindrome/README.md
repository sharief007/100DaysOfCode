[1328. Break a Palindrome](https://leetcode.com/problems/break-a-palindrome/)

Given a palindromic string of lowercase English letters palindrome, replace exactly one character with any lowercase English letter so that the resulting string is not a palindrome and that it is the lexicographically smallest one possible.

Return the resulting string. If there is no way to replace a character to make it not a palindrome, return an empty string.

A string a is lexicographically smaller than a string b (of the same length) if in the first position where a and b differ, a has a character strictly smaller than the corresponding character in b. For example, "abcc" is lexicographically smaller than "abcd" because the first position they differ is at the fourth character, and 'c' is smaller than 'd'.

```text
Input: palindrome = "abccba"
Output: "aaccba"
Explanation: There are many ways to make "abccba" not a palindrome, such as "zbccba", "aaccba", and "abacba".
Of all the ways, "aaccba" is the lexicographically smallest.
```

```text
Input: palindrome = "a"
Output: ""
Explanation: There is no way to replace a single character to make "a" not a palindrome, so return an empty string.
```

##### Hints
1. How to detect if there is impossible to perform the replacement? Only when the length = 1.
2. Change the first non 'a' character to 'a'.
2. What if the string has only 'a'?
4. Change the last character to 'b'.

### Approach 

- Time Complexity: O(N ^ 2)
- Space Complexity: O(1)

```java
class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() <= 1) return "";
        
        StringBuilder builder = new StringBuilder(palindrome);
        
        boolean change = false;
        for(int i = 0; i< palindrome.length(); i++) {
            char ch = builder.charAt(i);
            if( ch != 'a') {
                builder.setCharAt(i,'a');
                if(checkPalindrome(builder.toString())) {
                    builder.setCharAt(i, ch);
                    continue;
                }
                change = true;
                break;
            }
        }
        
        if(!change) {
            builder.setCharAt(palindrome.length()-1, 'b');
        }
        
        return builder.toString();
    }
    
    private boolean checkPalindrome(String str) {
        int i =0, j = str.length() - 1;
        
        while(i<j) {
            if(str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
```