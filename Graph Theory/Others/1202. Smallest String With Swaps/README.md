[1202. Smallest String With Swaps](https://leetcode.com/problems/smallest-string-with-swaps/)

You are given a string s, and an array of pairs of indices in the string pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string.

You can swap the characters at any pair of indices in the given pairs any number of times.

Return the lexicographically smallest string that s can be changed to after using the swaps.

```text
Input: s = "dcab", pairs = [[0,3],[1,2]]
Output: "bacd"
Explaination: 
Swap s[0] and s[3], s = "bcad"
Swap s[1] and s[2], s = "bacd"
```

### Approach (Union Find) - stolen

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
class UF {
  public UF(int n) {
    id = new int[n];
    for (int i = 0; i < n; ++i)
      id[i] = i;
  }

  public void union(int u, int v) {
    id[find(u)] = find(v);
  }

  public int find(int u) {
    return id[u] == u ? u : (id[u] = find(id[u]));
  }

  private int[] id;
}

class Solution {
  public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
    StringBuilder ans = new StringBuilder();
    UF uf = new UF(s.length());
    Map<Integer, Queue<Character>> map = new HashMap<>();

    for (List<Integer> pair : pairs)
      uf.union(pair.get(0), pair.get(1));

    for (int i = 0; i < s.length(); ++i)
      map.computeIfAbsent(uf.find(i), k -> new PriorityQueue<>()).offer(s.charAt(i));

    for (int i = 0; i < s.length(); ++i)
      ans.append(map.get(uf.find(i)).poll());

    return ans.toString();
  }
}
```