
[763. Partition Labels](https://leetcode.com/problems/partition-labels/)

### Approach - 1

[Youtube Explanation](https://www.youtube.com/watch?v=5NCjHqx2v-k)

Time Complexity: O(n)

Space Complexity: O(1)

```java
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        if(Objects.isNull(s) || s.length() == 0) return list;
        
        int n = s.length(), start = 0, end = 0;
        char[] arr = s.toCharArray();
        int[] lastIndex = new int[26];
        
        for(int i=0;i<n;i++) {
            lastIndex[arr[i]-'a'] = i;
        }
        
        for(int i=0;i<n;i++) {
            end = Math.max(end, lastIndex[arr[i]-'a']);
            if(i==end) {
                list.add(end-start+1);
                start = end+1;
            }
        }
        return list;
    }
}
```