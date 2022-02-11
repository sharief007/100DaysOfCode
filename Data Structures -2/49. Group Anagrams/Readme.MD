
[49. Group Anagrams](https://leetcode.com/problems/group-anagrams/)

[Youtube Explanation](https://www.youtube.com/watch?v=0I6IL3TnIZs)

### Approach

Time Complexity: O(n)
Space Complexity: O(1)

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        
        for(String str : strs) {
            String val = str;
            char[] key = str.toCharArray();
            Arrays.sort(key);
            str = new String(key);
            if(map.containsKey(str)) {
                List<String> strings = map.get(str);
                strings.add(val);
                map.put(str, strings);
            } else {
                List<String> strings = new ArrayList<>();
                strings.add(val);
                map.put(str, strings );
            }
        }
        for(Map.Entry<String, List<String>> entry: map.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }
}
```