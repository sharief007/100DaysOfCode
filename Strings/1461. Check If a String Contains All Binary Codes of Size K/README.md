[1461. Check If a String Contains All Binary Codes of Size K](https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/)

### Approach - 1 (Brute Force) mine

- Time Complexity: O(N*K) (because substring method) (401ms)
- Space Complexity: O(2^K)

```java
class Solution {
    public boolean hasAllCodes(String s, int k) {
        int len = s.length();
        
        // number range possible
        int range = (int) Math.pow(2,k);
        
        boolean[] found = new boolean[range];
        
        // apply sliding window technique
        for(int i=0;i<=len-k; i++) {
            String code = s.substring(i, i+k);
            int val = Integer.parseInt(code, 2);
            found[val] = true;
        }
        
        // if any value not found, return false
        for(boolean bool : found) {
            if(!bool) return false;
        }
        
        return true;
    }
}
```
### Approach - 2 (Hashset)

similar but Intelligent trick

- Time Complexity: O(N*K) because of substring method   (153ms)
- Space Complexity: O(2^K)

```java
class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> codes = new HashSet<>();
        int total = 1 << k;
        
        for (int i=0; i+k<=s.length(); i++) {
            codes.add(s.substring(i, i+k));
            if (codes.size() == total) return true;
        }
        
        return false;
    }
}
```

### Approach - 3

- Time Complexity: O(N)
- Space Complexity: O(2^K)

```java
class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<Integer> codes = new HashSet<>();
        int total = 1 << k, allOnes = total - 1, hashCode = 0;
        
        for (int i=0; i<s.length(); i++) {
            hashCode = ((hashCode << 1) & allOnes) | (s.charAt(i) - '0');
            if (i >= k-1 && codes.add(hashCode) && codes.size() == total) return true;
        }
        
        return false;
    }
}
```