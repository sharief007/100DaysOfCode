
[415. Add Strings](https://leetcode.com/problems/add-strings/)

### Approach 

Time complexity: O(n)

Space Complexity: O(1)

```java
class Solution {
    public String addStrings(String num1, String num2) {
        int n = num1.length(), m = num2.length();
        int i = 0, sum = 0, carry = 0;
        StringBuilder builder = new StringBuilder();
        
        while( i<n && i<m ) {
            sum = carry;
            int n1 = num1.charAt(n-1-i) - '0', n2 = num2.charAt(m-1-i) - '0';
            sum += (n1+n2);
            if(sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            builder.append(sum);
            ++i;
        }
        int j = i;
        while(i<n) {
            sum = carry;
            int n1 = num1.charAt(n-1-i) - '0';
            sum += n1;
            if(sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            builder.append(sum);
            ++i;
        }
        while(j<m) {
            sum = carry;
            int n2 = num2.charAt(m-1-j) - '0';
            sum += n2;
            if(sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            builder.append(sum);
            ++j;
        }
        if(carry > 0) {
            builder.append(carry);
        }
        
        return builder.reverse().toString();
    }
}
```