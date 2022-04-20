[923. 3Sum With Multiplicity](https://leetcode.com/problems/3sum-with-multiplicity/description/)

### Approach

[Youtube Explanation](https://youtu.be/jZcAldZP1ag)

1. Use three pointers (two loops only)
2. store frequency of elements in an array
3. use i,j to find k = target - arr[i] - arr[j]
4. check if frequency arr has k
5. if exists, result += frequency.

- Time Complexity :O(N^2)
- Space Complexity :O(N)

```java
class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int n = arr.length, mod = 1_000_000_007;
        long result = 0;
        for(int i=0;i<n;i++) {
            int[] count = new int[101];
            for(int j=i+1;j<n;j++) {
                int k = target - arr[i] - arr[j];
                if(k>=0 && k<=100 && count[k]>0) {
                    result += count[k];
                    result %=mod;
                }
                count[arr[j]]++;
            }
        }
        return (int) result;
    }
}
```

### Approach 2

[Youtube Explanation](https://youtu.be/jZcAldZP1ag)

- Time Complexity: O(100*100 + N) ~ O(N)
- Space Complexity: O(N)


```java

```