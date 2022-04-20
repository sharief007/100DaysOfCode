
[43. Multiply Strings](https://leetcode.com/problems/multiply-strings/)

### Approach 

Time Complexity: O((n*m)(m)) or O((n*m)(n))

Space Complexity: O(1)

```java
class Solution {
    public String multiply(String num1, String num2) {
        int n = num1.length(), m = num2.length();
        
        String ans = "";
        
        for(int i=m-1; i>=0;i--) {
            int r = num2.charAt(i) - '0', carry = 0;
            StringBuilder builder = new StringBuilder();
            for(int j=n-1;j>=0;j--) {
                int l = num1.charAt(j) - '0';
                int prod = l*r;
                if(carry > 0) {
                    prod += carry;
                    carry = 0;
                }
                if(prod > 9) {
                    carry = prod / 10;
                    prod = prod % 10;
                }
                builder.append(prod);
            }
            if(carry > 0) {
                builder.append(carry);
            }
            builder = builder.reverse();
            for(int k=0;k<m-1-i;k++) {
                builder.append(0);
            }
            ans = addStrings(ans, builder.toString());
        }
        
        int i =0, len = ans.length();
        while(i<len-1 && ans.charAt(i)=='0') i++;
        
        return i>0 ? ans.substring(i) : ans;
        
    }
    
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