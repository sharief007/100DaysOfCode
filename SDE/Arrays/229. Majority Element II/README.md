
[229. Majority Element II](https://leetcode.com/problems/majority-element-ii/)


### Approach (HashMap)

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i:nums) {
            if(map.containsKey(i)) {
                int c = map.get(i);
                c++;
                map.put(i,c);
            } else {
                map.put(i,1);
            }
        }
        for(Map.Entry<Integer,Integer> kv : map.entrySet()) {
            if(kv.getValue()>nums.length/3) list.add(kv.getKey());
        }
        return list;
    }
}
```

### Approach (boyer moorse algorithm) 

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int num1 = -1, num2 = -1, c1 = 0, c2 = 0;
        
        int n = nums.length;
        
        for(int i : nums) {
            if(num1 == i) {
                c1++;
            } else if (num2 == i) {
                c2++;
            } else if (c1 == 0) {
                num1 = i;
                c1 = 1;
            } else if (c2 == 0) {
                num2 = i;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }
        
        c1 = c2 = 0;
        
        for(int i : nums) {
            if(num1  == i) {
                c1++;
            } else if(num2 == i) {
                c2++;
            }
        }
        
        if(c1 > n/3) {
            list.add(num1);
        }
        
        if(c2 > n/3) {
            list.add(num2);
        }
        
        return list;
    }
}
```