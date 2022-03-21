
[127. Word Ladder](https://leetcode.com/problems/word-ladder/)

### Approach (Watch this amazing video)

[Youtube Explanation](https://www.youtube.com/watch?v=ZVJ3asMoZ18)

Complexity Analysis: Watch the video

```java
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        char[] alphabet = {
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n',
            'o','p','q','r','s','t','u','v','w','x','y','z'
        };
        wordList.forEach(word -> set.add(word));
        
        queue.add(beginWord);
        
        int level = 0;
        while(queue.size() > 0) {
            int size = queue.size();
            level++;
            while(size-->0) {
                String word = queue.remove();
                StringBuilder builder = new StringBuilder(word);
                
                for(int i=0;i<word.length();i++) {
                    char ch = builder.charAt(i);
                    
                    for(char alpha: alphabet) {
                        if(alpha == ch) continue;
                        
                        builder.setCharAt(i, alpha);
                        String newComb = builder.toString();
                        if(set.contains(newComb)) {
                            // System.out.println(newComb);
                            if(newComb.equals(endWord)) {
                                return 1 + level;
                            }
                            queue.add(newComb);
                            set.remove(newComb);
                        }
                    }
                    builder.setCharAt(i, ch);
                }
            }
        }
        return 0;
    }
}
```