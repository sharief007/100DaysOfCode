[239. Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)

### Approach - 1 (Brute Force)

- Time Complexity: O(N^2)   ~ TLE (40 / 51 test cases passed)
- Space Complexity: O(1)

```java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        
        int[] result = new int[n-k+1];
        int idx = 0;
        
        for(int i=0; i<n-k+1; i++) {
            int maxVal = Integer.MIN_VALUE;
            
            for(int j=i; j<i+k; j++) {
                maxVal = Math.max(maxVal, nums[j]);
            }
            
            result[idx++] = maxVal;
        }
        return result;
    }
}
```

### Approach - 2

[NeetCode Explanation](https://www.youtube.com/watch?v=DfljaUwZsOk)
[Striver Explanation](https://www.youtube.com/watch?v=CZQGRp93K4k&t=872s)

- Time Complexity: O(N)
- Space Complexity: O(N)

``` java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        
        int[] result = new int[n-k+1];
        int idx = 0;
        
        for(int i=0; i<n; i++) {
            // deque should contains less than equal to k elements at a Time
            // remove other elements
            while( !deque.isEmpty() && deque.peekFirst() <= i-k ) {
                deque.removeFirst();
            }

            // remove elements which are less than current element
            while( !deque.isEmpty() && nums[ deque.peekLast() ] < nums[i]) {
                deque.removeLast();
            }
            
            deque.addLast(i);
            
            // result starts from k-1
            if( i >= k-1) {
                result[idx++] = nums[ deque.peekFirst() ];
            }
            
        }
        return result;
    }
}
```