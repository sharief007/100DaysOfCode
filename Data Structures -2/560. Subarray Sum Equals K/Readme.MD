
[560. Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/)

Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

### Approach - 1

89/89 testcases passed, but took too long.
status: Time Limit Exceeded  

Time Complexity: O(n^2)

Space Complexity: O(1)

```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length, count =0;
        for(int i=0;i<n;i++) {
            int sum = 0;
            for(int j=i;j<n;j++) {
                sum += nums[j];
                if(sum == k) count++;
            }
        }
        return count;
    }
}
```

### Approach - 2
[Youtube Explanation](https://www.youtube.com/watch?v=fFVZt-6sgyo)

Time Complexity: O(n)

Space COmplexity: O(n)

```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length, count = 0, sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            sum += nums[i];
            if(sum == k) {
                count++;
            } 
            if(map.containsKey(sum-k)) {
                count+=map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }  
}
```