
[18. 4Sum](https://leetcode.com/problems/4sum/)

Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

- 0 <= a, b, c, d < n
- a, b, c, and d are distinct.
- nums[a] + nums[b] + nums[c] + nums[d] == target

You may return the answer in any order.

[Youtube Explanation](https://www.youtube.com/watch?v=4ggF3tXIAp0)

### Approach - 1

Algorithm Analysis:
- Sorting Time Complexity: O(nlogn)
- Binary Search Time Complexity: O(logn)
- 3 Loops: O(n^3)
- HashSet (insert operation) : O(logn)

Time complexity : O(n^3 logn + nlogn) = O(n^3 logn)

Space Complexity: O(n)

```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new LinkedList<>();
        int n = nums.length;
        
        //sort the Array
        Arrays.sort(nums);

        // hashset to sore unique quadruplets
        Set<List<Integer>> set = new HashSet<>();

        for(int i = 0;i<n-3;i++) {
            for(int j=i+1;j<n-2;j++) {
                for(int k=j+1;k<n-1;k++) {
                    int rem = target - (nums[i] + nums[j] + nums[k]);
                    System.out.println(String.format("rem=%s,k+1=%s",rem,k+1));
                    int index = Arrays.binarySearch(nums,k+1, n, rem);
                    System.out.println(index);
                    if(index >= 0 ){
                        set.add(Arrays.asList(nums[i],nums[j],nums[k],nums[index]));
                    }
                    while(k+1<n && nums[k]==nums[k+1]) k++;
                }
                while(j+1<n && nums[j] == nums[j+1]) j++;
            }
            while(i+1<n && nums[i]==nums[i+1]) i++;
        }
        
        Iterator<List<Integer>> itr = set.iterator();
        while(itr.hasNext()) {
            list.add(itr.next());
        }
        return list;
    }
}
```

### Approach -2

Time Complexity: O(n^3)
Space Complexity: O(1)

```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new LinkedList<>();
        int n = nums.length;
        
        //sort the Array
        Arrays.sort(nums);

        for(int i = 0;i<n-2;i++) {
            for(int j=i+1;j<n-1;j++) {
                int left = j+1, right = n-1;
                while(left<right) {
                    int sum = nums[i]+nums[j]+nums[left]+nums[right];
                    if(target > sum) {
                        left++;
                    } else if(target < sum) {
                        right--;
                    } else {
                        list.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left++;
                        right--;
                        while(left< n && nums[left]==nums[left-1]) left++;
                        while(right>= 0 && nums[right]==nums[right+1]) right--;
                    }
                }
                while(j+1<n && nums[j]==nums[j+1]) j++;
            }
            while(i+1<n && nums[i]==nums[i+1]) i++;
        }

        return list;
    }
}
```

---------------------

[454. 4Sum ii](https://leetcode.com/problems/4sum-ii/)

Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:

- 0 <= i, j, k, l < n
- nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0

[Youtube explanation](https://www.youtube.com/watch?v=XHlA0KdvQBc)

### Approach -1 

Time Complexity: O(n^4)

Space Complexity: O(1)

``` java
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        for(int a: nums1) {
            for(int b: nums2) {
                for(int c :nums3) {
                    for(int d: nums4) {
                        if(a+b+c+d==0) count++;
                    }
                }
            }
        }
        return count;
    }
}
```

### Approach - 2 (Better Solution)

Time complexity: O(n^3)

Space Complexity: O(n)

```java
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map = new LinkedHashMap<>();
        int count = 0;

        for(int d: nums4) {
            map.put(d, map.getOrDefault(d, 0)+1);
        }
        
        for(int a: nums1) {
            for(int b: nums2) {
                for(int c: nums3) {
                    count += map.getOrDefault(-(a+b+c), 0);
                }
            }
        }
        return count;
    }
}
```


### Approach - 3 (Optimal Solution)

Time complexity : O(n^2)

Space Complexity: O(n^2)

``` java
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map = new LinkedHashMap<>();
        int count = 0;
        for(int c: nums3) {
            for(int d: nums4) {
                map.put(c+d, map.getOrDefault(c+d, 0)+1);
            }
        }
        
        for(int a: nums1) {
            for(int b: nums2) {
                count += map.getOrDefault(-(a+b), 0);
            }
        }
        return count;
    }
}
```