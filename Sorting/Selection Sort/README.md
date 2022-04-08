
### Selection Sort

- Time Complexity: O(N^2)
- Space Complexity: O(1)

Example

```text
arr[] = 64 25 12 22 11

// Find the minimum element in arr[0...4]
// and place it at beginning
11 25 12 22 64

// Find the minimum element in arr[1...4]
// and place it at beginning of arr[1...4]
11 12 25 22 64

// Find the minimum element in arr[2...4]
// and place it at beginning of arr[2...4]
11 12 22 25 64

// Find the minimum element in arr[3...4]
// and place it at beginning of arr[3...4]
11 12 22 25 64 
```

```java

class Sorting {
    public void SelectionSort(int[] nums) {
        int n = nums.length;

        for(int i=0;i<n-1;i++) {
            int minIndx = findMinIndexFrom(nums, i);
            swap(nums, minIndx, i);
        }

    }

    private int findMinIndexFrom(int[] nums, int start) {
        int idx = start;
        for(int i=idx; i<nums.length;i++) {
            idx = nums[i] < nums[idx] ? i : idx;
        }
        return idx;
    }

    private void swap(int[] nums, int i,int j) {
        if(i!=j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}

```