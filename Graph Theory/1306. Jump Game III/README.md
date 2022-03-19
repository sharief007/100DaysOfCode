
[1306. Jump Game III](https://leetcode.com/problems/jump-game-iii/)

Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.

Notice that you can not jump outside of the array at any time.

```text
Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation: 
All possible ways to reach at index 3 with value 0 are: 
index 5 -> index 4 -> index 1 -> index 3 
index 5 -> index 6 -> index 4 -> index 1 -> index 3 
```

### Approach (BFS)

[Youtube Explanation](https://www.youtube.com/watch?v=7Cz91Uj0VCU)

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
class Solution {
    public boolean canReach(int[] arr, int start) {
        
        if(arr[start] == 0) return true;
        
        int n = arr.length;
        boolean[] visited = new boolean[n];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        
        while(queue.size() > 0) {
            int idx = queue.remove();
            
            int left = idx - arr[idx], right = idx + arr[idx];
            if(left >= 0 && !visited[left]) {
                if(arr[left] == 0) return true;
                else {
                    queue.add(left);
                    visited[left] = true;
                }
            }
            
            if(right < n && !visited[right]) {
                if(arr[right] == 0) return true;
                else  {
                    queue.add(right);
                    visited[right] = true;
                }
            }
        }
        return false;
    }
}
```