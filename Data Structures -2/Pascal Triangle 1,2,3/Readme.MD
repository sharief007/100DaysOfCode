[Pascal Triangle -1](https://leetcode.com/problems/pascals-triangle)

![Pascal's Triangle](https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif)

### Approach

Time Complexity: O(n^2)
Space Complexity: O(n^2)

```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        for(int i=1;i<=numRows;i++) {
            List<Integer> row = new ArrayList<>();
            for(int j=1;j<=i;j++) {
                if(j==1 || j==i) {
                   row.add(1);
                    continue;
                }
                List<Integer> prev = answer.get(i-2);
                int val = prev.get(j-1) + prev.get(j-2);
                row.add(val);
            }
            answer.add(row);
        }
        return answer;
    }
}
```


[Pascal Triangle - 2](https://leetcode.com/problems/pascals-triangle-ii/)

Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

![Pascal's Triangle](https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif)


### Approach - 1
[Youtube Tutorial](https://www.youtube.com/watch?v=6FLvhQjZqvM)

Any particular value in pascal's triangle can be derived as 
row C col

Time Complexity: O(n)
Space Complexity: O(1)

```java
class Solution {
    public List<Integer> getRow(int n) {
        List<Integer> res = new ArrayList<>();
        long val = 1;
        for(int r = 0; r <= n; r++) {
            res.add((int)val);
            val = val * (n - r) / (r + 1); 
        }
        return res;
    }
}
```
