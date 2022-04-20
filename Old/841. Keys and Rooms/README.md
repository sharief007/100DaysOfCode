
[841. Keys and Rooms](https://leetcode.com/problems/keys-and-rooms/)

### Approach -1

[Youtube Explanation](https://www.youtube.com/watch?v=Rz_-Kx0LN-E)

- Time complexity: O(N)
- Space Complexity: O(N)

```java
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int totalRooms = rooms.size();
        boolean[] visited = new boolean[totalRooms];
        visited[0] = true;
        
        final Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        while(stack.size() > 0) {
            int room = stack.pop();
            rooms.get(room).forEach(r->{
                if(!visited[r]) {
                    visited[r] = true;
                    stack.push(r);
                }
            });
        }
        
        for(boolean visit : visited) {
            if(!visit) {
                return false;
            }
        }
        return true;
    }
}
```