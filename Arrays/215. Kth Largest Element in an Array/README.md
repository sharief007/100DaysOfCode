
[215. Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)

### Approach - 1 (use priority queue)

- Time Complexity: O(nlogn + klogn)
- Space Complexity: O(N)

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i: nums) queue.add(i);
        for(int i=0;i<nums.length-k;i++) {
            queue.poll();
        }
        return queue.poll();
    }
}
```

### Approach - 2 (Quick Select)

- Time Complexity: O(nlogn)
- Space Complexity: O(1)

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length-1, nums.length-k);
    }
    
     public static int quickSelect(int []nums, int low, int high, int k){
         int pivot = nums[high];
         int pi = partition(nums, low, high, pivot);
         
         if(k > pi){
             return quickSelect(nums, pi+1, high, k);
         }
         else if(k < pi){
             return quickSelect(nums, low, pi-1, k);
         }
         else{
             return pivot;
         }
     }
    
    public static int partition(int []nums, int low, int high, int pivot){
        int i=low;
        int j=low;
        while(i<=high){
            if(nums[i]>pivot)
                i++;
            else if(nums[i]<=pivot){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }
        }
        return j-1;
    }
}
```