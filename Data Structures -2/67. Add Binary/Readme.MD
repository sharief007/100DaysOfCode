
[67. Add Binary](https://leetcode.com/problems/add-binary/)

### Approach - 1 (my shitty approach)

Time Complexity: O(n)

Space Complexity: O(1)

```java
class Solution {
    public String addBinary(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        StringBuilder builder = new StringBuilder();
        boolean carry = false;
        int n = a.length(), m = b.length(), i =0;
        for(;i<Math.min(n,m);i++) {
            if(a.charAt(i)=='1' && b.charAt(i)=='1') {
                if(carry) {
                    builder.append('1');
                    carry = true;
                } else {
                    builder.append('0');
                    carry = true;
                }
            } else if(a.charAt(i)=='1' && b.charAt(i)=='0') {
                if(carry) {
                    builder.append('0');
                    carry = true;
                } else {
                    builder.append('1');
                    carry = false;
                }
            } else if(a.charAt(i)=='0' && b.charAt(i)=='1') {
                if(carry) {
                    builder.append('0');
                    carry = true;
                } else {
                    builder.append('1');
                    carry =  false;
                }
            } else if(a.charAt(i)=='0' && b.charAt(i)=='0') {
                if(carry) {
                    builder.append('1');
                    carry = false;
                } else {
                    builder.append('0');
                    carry = false;
                }
            }
        }
        int j = i;            
        while(i<n) {
            if(a.charAt(i)=='1' && carry) {
                carry = true;
                builder.append('0');
            } else if(a.charAt(i)=='0' && carry) {
                carry = false;
                builder.append('1');
            } else if(a.charAt(i) == '1' && !carry) {
                carry = false;
                builder.append('1');
            } else if(a.charAt(i) == '0' && !carry) {
                builder.append('0');
                carry = false;
            }
            i++;
        }         
                      
        while(j<m) {
            if(b.charAt(j)=='1' && carry) {
                carry = true;
                builder.append('0');
            } else if(b.charAt(j)=='0' && carry) {
                carry = false;
                builder.append('1');
            } else if(b.charAt(j) == '1' && !carry) {
                carry = false;
                builder.append('1');
            } else if(b.charAt(j) == '0' && !carry) {
                builder.append('0');
                carry = false;
            }
            j++;
        }
        
        if(carry) {
            builder.append('1');
        }
        
                      return builder.reverse().toString();
    }
}
```


### Approach - 2 (Stolen)

TIme Complexity: O(n)

Space COmplexity: O(1)

```java
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0){
            int sum = carry;
            if(i >= 0) sum += a.charAt(i--) - '0';
            if(j >= 0) sum += b.charAt(j--) - '0';
            carry = sum > 1 ? 1 : 0;
            res.append(sum % 2);
        }
        if(carry != 0) res.append(carry);
        return res.reverse().toString();
    }
}
```