
### Stable Selection Sort

- Time Complexity: O(N^2)
- Space Complexity: O(1)

Example 

```text
Example: 4A 5 3 2 4B 1
         First minimum element is 1, now instead
         of swapping. Insert 1 in its correct place 
         and pushing every element one step forward
         i.e forward pushing.
         1 4A 5 3 2 4B
         Next minimum is 2 :
         1 2 4A 5 3 4B
         Next minimum is 3 :
         1 2 3 4A 5 4B
         Repeat the steps until array is sorted.
         1 2 3 4A 4B 5
```

```java
class Sorting {
    public void stableSelectionSort(int[] nums) {
        int n = nums.length;

        for(int i=0;i<n-1;i++) {
            int minIndx = findMinIndexFrom(nums, i);
            shiftElements(nums, i, minIndx);
        }
    }

    private int findMinIndexFrom(int[] nums, int start) {
        int idx = start;
        for(int i=idx; i<nums.length;i++) {
            idx = nums[i] < nums[idx] ? i : idx;
        }
        return idx;
    }

    private void shiftElements(int[] nums, int start, int end) {
        int min = nums[end];
        for(int i=end;i>start;i--) {
            nums[i] = nums[i-1];
        }
        nums[start] = min;
    }


}
```