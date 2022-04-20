
[1249. Minimum Remove to Make Valid Parentheses](https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/)

### Approach - 1

Using a Stack

- Time Complexity: O(n)
- Space Complexity: O(n)

```java
class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0 ; i < s.length() ; i++){
            
            char ch = s.charAt(i);
            
            if(ch == '('){
                st.push(i);
            }
            else if(ch == ')'){
                if(st.size() > 0 && s.charAt(st.peek()) == '('){
                    st.pop();
                }
                else{
                    st.push(i);
                }
        }
    }
    
    char[] arr = s.toCharArray();
    
    while(st.size() > 0){
        int idx = st.pop();
        arr[idx] = '.'; // to avoid alphabets
    }
    
    StringBuilder sb = new StringBuilder();
    
    for(int i = 0 ; i < arr.length ; i++){
        if(arr[i] != '.'){
            sb.append(arr[i]);
        }
    }
    
    return sb.toString();
    }
}
```

### Approach - 2

- Time Complexity: O(n)
- Space Complexity: O(1)

```java
class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder builder = new StringBuilder(), result = new StringBuilder();
        int open = 0;
        for(char c: s.toCharArray()) {
            if(c == '(') {
                open++;
            } else if( c == ')') {
                if(open == 0) continue;
                open--;
            }
            builder.append(c);
        }
        
        for(int i=builder.length() - 1;i>=0;i--) {
            if(builder.charAt(i) == '(' && open > 0) {
                open--;
                continue;
            }
            result.append(builder.charAt(i));
        }
        return result.reverse().toString();
    }
}
```