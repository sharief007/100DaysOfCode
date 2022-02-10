
[290. Word Pattern](https://leetcode.com/problems/word-pattern/)

### Approach -1

[youtube tutorial](https://www.youtube.com/watch?v=dnlB0lvz5LY)

Time Complexity: O(n)

Space Complexity: O(1)

```java
class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map = new HashMap<>();
        HashMap<String,Character> used = new HashMap<>();
        String[] words = s.split(" ");
        if(words.length != pattern.length()) return false;
        for(int i=0;i<pattern.length();i++) {
            char ch = pattern.charAt(i);
            if(map.containsKey(ch) || used.containsKey(words[i])) {
                if(!words[i].equals(map.get(ch))) {
                    return false;
                }
                if(used.get(words[i]) != ch) {
                    return false;
                }
                continue;
            }
            map.put(ch,words[i]);
            used.put(words[i],ch);
        }
        return true;
    }
}
```