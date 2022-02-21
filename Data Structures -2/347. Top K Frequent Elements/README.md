
[347. Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)

### Approach - 1

[Youtube Explanation](https://www.youtube.com/watch?v=YPTqKIgVk-k)

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> frequency = new HashMap<>();
        List<Integer>[] cache = new LinkedList[n];
        final List<Integer> result= new LinkedList<>();
        
        for(int num: nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer,Integer> entry: frequency.entrySet()) {
            int idx = entry.getValue() - 1;
            if(cache[idx] == null) {
                cache[idx] = new LinkedList<Integer>();
            }
            cache[idx].add(entry.getKey());
        }        
        for(int i=n-1;i>=0 && k>0;i--) {
            if(cache[i] != null) {
                cache[i].forEach(key -> result.add(key));
                k = k - cache[i].size();
            } 
        }
        return result.stream().mapToInt(i->i).toArray();
    }
}
```