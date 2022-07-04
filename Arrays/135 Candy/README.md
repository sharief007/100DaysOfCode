
[135 Candy](https://leetcode.com/problems/candy/)

There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

``` text
Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
```

``` text
Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
```

Constraints:

- n == ratings.length
- 1 <= n <= 2 * 104
- 0 <= ratings[i] <= 2 * 104

### Approach

[Youtube Explanation](https://www.youtube.com/watch?v=h6_lIwZYHQw)

- Time Complexity: O(N)
- Space Complexity: O(N)

``` java

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        
        int[] leftToRight = new int[n];
        int[] rightToLeft = new int[n];
        
        Arrays.fill(leftToRight, 1);
        Arrays.fill(rightToLeft, 1);
        
        for(int i=1; i<n; i++) {
            if(ratings[i-1] < ratings[i]) {
                leftToRight[i] = leftToRight[i-1] + 1;
            }
        }
        
        for(int i=n-2; i>=0; i--) {
            if(ratings[i]>ratings[i+1]) {
                rightToLeft[i] = rightToLeft[i+1] + 1;
            }
        }
        
        int result = 0;
        
        for(int i=0; i<n; i++) {
            result += Math.max(leftToRight[i], rightToLeft[i]);
        }
        
        return result;
    }
}

```