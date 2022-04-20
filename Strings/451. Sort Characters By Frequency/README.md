
[451. Sort Characters By Frequency](https://leetcode.com/problems/sort-characters-by-frequency/)

### Approach - 1

Similar to 347. Top K Frequent Elements problem (belongs to same repo).

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
class Solution {
    public String frequencySort(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();
        
        Map<Character,Integer> hashMap = new HashMap<>();
        List[] cache = new List[n];
        final StringBuilder builder = new StringBuilder();
        
        for(char ch : arr) {
            hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
        }
        
        for(Map.Entry<Character,Integer> entry: hashMap.entrySet()) {
            int idx = entry.getValue() - 1;
            if(cache[idx] == null) {
                cache[idx] = new LinkedList<Character>();
            }
            cache[idx].add(entry.getKey());
        }
        
        for(int i=n-1;i>=0;i--) {
            if(cache[i] != null) {
                List<Character> chars = cache[i];
                for(char ch: chars) {
                     for(int k=0;k<=i;k++) {
                       builder.append(ch);
                   } 
                }
            }
        }
        return builder.toString();
    }
}
```