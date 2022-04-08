
### Bubble Sort

- Time Complexity: O(N^2)
- Space Complexity: O(1)

```java
class Sorting {
    public void bubbleSort(int[] nums) {
        int n = nums.length;

        for(int i=0;i<n-1;i++) {
            for(int j=0;j<n-i;j++) {
                if(nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
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

##### Recursive Approach

```java
// A function to implement bubble sort
static void bubbleSort(int arr[], int n)
{
    // Base case
    if (n == 1)
        return;

    // One pass of bubble sort. After
    // this pass, the largest element
    // is moved (or bubbled) to end.
    for (int i=0; i<n-1; i++)
        if (arr[i] > arr[i+1])
        {
            // swap arr[i], arr[i+1]
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }

    // Largest element is fixed,
    // recur for remaining array
    bubbleSort(arr, n-1);
}
```