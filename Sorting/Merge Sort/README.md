
### Merge Sort

- Time Complexity: O(N * LogN)
- Space Complexity: O(N)


```java
class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length -1);
        
        return nums;
    }
    
    private void mergeSort(int[] nums, int i, int j) {
        if(i < j) {
            int mid = i + (j-i) /2;
            
            mergeSort(nums, i, mid);
            mergeSort(nums, mid+1, j);
            
            merge(nums, i, mid, j);
        }
    }
    
    private void merge(int[] nums, int low, int mid, int high) {
        int left = low, right = mid + 1;
        ArrayList<Integer> list = new ArrayList<>();
        
        while(left <= mid && right <= high) {
            if(nums[left] <= nums[right]) {
                list.add(nums[left]);
                left++;
            } else {
                list.add(nums[right]);
                right++;
            }
        }
        
        while(left <= mid) {
            list.add(nums[left]);
            left++;
        }
        
        while(right <= high) {
            list.add(nums[right]);
            right++;
        }
        
        for(int i=low;i<=high;i++) {
            nums[i] = list.get(i - low);
        }
    }
}
```