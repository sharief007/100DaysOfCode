
[1615. Maximal Network Rank](https://leetcode.com/problems/maximal-network-rank/)

There is an infrastructure of n cities with some number of roads connecting these cities. Each roads[i] = [ai, bi] indicates that there is a bidirectional road between cities ai and bi.

The network rank of two different cities is defined as the total number of directly connected roads to either city. If a road is directly connected to both cities, it is only counted once.

The maximal network rank of the infrastructure is the maximum network rank of all pairs of different cities.

Given the integer n and the array roads, return the maximal network rank of the entire infrastructure.

Example - 1:

![Example Image](https://assets.leetcode.com/uploads/2020/09/21/ex1.png)
```text
Input: n = 4, roads = [[0,1],[0,3],[1,2],[1,3]]
Output: 4
Explanation: The network rank of cities 0 and 1 is 4 as there are 4 roads that are connected to either 0 or 1. The road between 0 and 1 is only counted once.
```

### Approach 

Degree of a node: all edges from that node.

1. Rank of two nodes is equivalent to degree of nodes. Except if there is a common edge connecting both the nodes then it should be counted only once.
2. So rank of A & B = deg(A) + deg(B)
3. If there is a edge between A & B then rank = rank -1. (Common edge should be counted once)

###### Algorithm:
1. Construct a undirected graph using adjacency matrix.
2. Calculate the degree of each node
3. Consider all possible pair of nodes (0-n). (Two loops)
4. Find rank of all pairs and evaluate the max rank.


- Time Complexity: O(N^2)
- Space Complexity: O(N)

```java
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] connections = new boolean[n][n];
        int[] degrees = new int[n];
        
        for(int[] road: roads) {
            int from = road[0], to = road[1];
            
            connections[from][to] = true;
            connections[to][from] = true;
            
            degrees[from]++;
            degrees[to]++;            
        }
        
        int maxRank = Integer.MIN_VALUE;
        
        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<n;j++) {

                if(i!=j) {          // pair cannot contain same nodes
                    int rank = degrees[i] + degrees[j]; 
                    if(connections[i][j] || connections[j][i]) {    //common edge in between 
                        rank--;
                    }
                    maxRank = Math.max(maxRank, rank);
                }
            }
        }
        return maxRank;
    }
}
```