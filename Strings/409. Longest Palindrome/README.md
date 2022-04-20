[409. Longest Palindrome](https://leetcode.com/problems/longest-palindrome/)

### Approach - 1

[Useful Link](https://warmland.gitbooks.io/algorithm/content/leetcode/401-450/409_longest_palindrome.html)

Time Complexity: O(n)
Space Complexity: O(n)

```java
class Solution {
    public int longestPalindrome(String s) {
        if(Objects.isNull(s)) return 0;
        
        int n = s.length();
        if(n<=1) return n;
        
        int[] cache = new int[128];
        char[] str = s.toCharArray();
        boolean odd = false;
        int len = 0;
        for(char ch: str) cache[ch]++;
        
        for(int count: cache) {
            if(count%2 == 0) {
                len += count;
            } else {
                len += count - 1;
                odd = true;
            }
        }
        
        if(odd) len++;
        
        return len;
    }
}
```


---------------------------------------------

#### Same Solution using HashMap

```java
class Solution {
    public int longestPalindrome(String s) {
        if(Objects.isNull(s)) return 0;
        
        int n = s.length(), longest = 0;
        if(n<=1) return n;
        
        boolean oddCount = false;
        Map<Character,Integer> map = new HashMap<>();
        
        for(char ch: s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        for(Map.Entry<Character,Integer> entry: map.entrySet()) {
            int count = entry.getValue();
            if( count%2 == 0) {
                longest += count;
            } else {
                longest += (count-1);
                oddCount = true;
            }
        }
        
        if(oddCount) longest++;
        
        return longest;
    }
}
```