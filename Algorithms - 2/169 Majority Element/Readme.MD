[169. Majority Element](https://leetcode.com/problems/majority-element/)


### Approach -1

Time Complexity : O(n)
Space Complexity : O(n)

``` java
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


### Approach - 2
Moorse voting Algorithm
Time complexity : O(n)
Space Complexity : O(1)

``` java
class Solution {
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        
        for(int i=1; i<nums.length; i++){
            if(nums[i] == major){
                count++;
            }else if(count != 0){
              count--;
            }else{
                count = 1;
                major = nums[i];
            }
        }
        return major;
    }
}
```

[# Video Solution](https://youtu.be/AoX3BPWNnoE)