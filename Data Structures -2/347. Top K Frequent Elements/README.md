
[347. Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)

### Approach - 1 (Use priority queue/heap)

- Time Complexity: O(N*LogN + K*LogN)
- Space Complexity: O(N)

```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // to store the frequency of each element in array
        Map<Integer,Integer> map = new HashMap<>();
        
        // give priority to those which have high frequency
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        int[] result = new int[k];  // resultant array with size k
        
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1); // maintain a count of every element
        }
        
        for(int key: map.keySet()) {
            pq.add(key); // add all elements to queue, takes O(logn) time for each operation
        }
        
        for(int i = 0; i < k; i++) {
            result[i] = pq.poll(); // get k elements with priority, takes O(logn) time
        }
        
        return result;
    }
}
```

### Approach - 2

[Youtube Explanation](https://www.youtube.com/watch?v=YPTqKIgVk-k)

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        // to store the frequency of each element
        Map<Integer,Integer> frequency = new HashMap<>();

        // to create custom hashmap functionality
        List<Integer>[] cache = new LinkedList[n];

        final List<Integer> result= new LinkedList<>();
        
        // find the frequency of every element and store it in hashmap
        for(int num: nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        // the maximum frequency of any elements will always be less than equal to N (size of array).
        // that is why we created an array of size N.
        // there can be multiple keys with same frequency value, so each index may have multiple values.
        for(Map.Entry<Integer,Integer> entry: frequency.entrySet()) {
            int idx = entry.getValue() - 1;     // since index starts from 0
            if(cache[idx] == null) {            
                cache[idx] = new LinkedList<Integer>();
            }
            cache[idx].add(entry.getKey());     // add key to list with same frequency value
        }        

        // iterate from high to low, because we need values with more frequency
        for(int i=n-1;i>=0 && k>0;i--) {    // we need only k values
            if(cache[i] != null) {          // if there is an element with this frequency
                cache[i].forEach(key -> result.add(key));   // consider all the elements
                k = k - cache[i].size();            // dont forget to substract k 
            } 
        }
        return result.stream().mapToInt(i->i).toArray();    // list to arrray
    }
}
```