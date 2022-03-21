
[763. Partition Labels](https://leetcode.com/problems/partition-labels/)

You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

Return a list of integers representing the size of these parts.

```text
Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
```

### Approach - 1

- Time Complexity: O(N)
- Space Complexity: O(1)

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