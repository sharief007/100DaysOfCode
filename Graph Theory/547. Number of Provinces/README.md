[547. Number of Provinces](https://leetcode.com/problems/number-of-provinces/)

There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

![Example](https://assets.leetcode.com/uploads/2020/12/24/graph1.jpg)

### Approach (DFS)

- Time Complexity: O(N*M)
- Space Complexity: O(N*M)

```java
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];
        int count = 0;
        for(int i=0;i<n;i++) {
          if(visited[i] == 0) {
              visitAllConnected(isConnected,i,visited);
              count++;
          }  
        } 
        return count;
    }
    
    private void visitAllConnected(int[][] arr, int i, int[] visited) {
        for(int j =0; j<arr.length; j++) {
            if(arr[i][j] == 1 && visited[j]==0) {
                visited[j] = 1;
                visitAllConnected(arr, j, visited);
            }
        }
    }
}
```