
[169. Majority Element](https://leetcode.com/problems/majority-element/)

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

```text
Input: nums = [3,2,3]
Output: 3
```


### Approach - 1

- Time Complexity: O(N^2)   ~ 43/43 TLE
- Space Complexity: O(1)

```java
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int majority = 0, element = 0;
        for(int i=0;i<n;i++) {
            int count =0;
            for(int j=0;j<n;j++) {
                if(nums[i] == nums[j]) {
                    count++;
                }
            }
            if(count > majority) {
                majority = count;
                element = nums[i];
            }
        }
        return element;
    }
}
```

### Approach - 2 (Hash Map)

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i: nums) {
            if(map.containsKey(i)) {
                int c = map.get(i);
                c++;
                map.put(i,c);
            } else {
                map.put(i,1);
            }
        }
        int max = Integer.MIN_VALUE, key = 0;
        for(Map.Entry<Integer,Integer> i : map.entrySet()) {
         if(max<i.getValue())  {
             max = i.getValue();
             key = i.getKey();
         }   
        }
        return key;
    }
}
```

### Approach (Moorse Voting Algorithm)

- Time Complexity: O(N
- Space Complexity: O(1)

```java
class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums[0], n = nums.length, count =1;
        for(int i =1;i<n;i++) {
            if(majority == nums[i]) count++;
            else count--;
            
            if(count == 0) {
                majority = nums[i];
                count = 1;
            }
        }
        return majority;
    }
}
```