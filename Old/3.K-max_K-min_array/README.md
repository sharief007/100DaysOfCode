# NOTES
## Kth Maximun and Kth Minimum element in an Array

### Method-1
1. Sort the array in ascending order
2. kth maximum = arr[length-k]
3. kth minimum = arr[k-1]

Time complexity: O(nLogn)

### Method -2
1. Initialize a min Heap (Priority queue) and add all elements to it.
2. For Kth largest element: 
    poll **length-k** times and peek once.
3. For Kth smallest element:
    poll **k-1** times and peek once.

Time complexity: O(n)
space complexity: O(n)

