# NOTES
## Sort an Array of 0z, 1s, and 2s

### Method-1
1. Sort the array using any sorting algorithm

### Method-2
1. Traverse the array and count all 0s,1s and 2s in c1,c2,c3
2. replace first c1 elements with 0
3. replace next c2 elements with 1.
4. replace next c3 elements with 2.

Time complexity: O(n)
space complexity: O(1)

### Method-3
1. Initialize 3 pointers(indices). **left,mid = 0 and right = length-1**
2. loop through the array **while (mid<=right)**
3. if arr[mid] is 0, swap elements at left and mid. increment left, mid.
4. if arr[mid] is 1, increment mid.
5. if arr[mid] is 2, swap elements at mid, right. increment mid, decrement right.

Time Complexity: O(n)
Space Complexity: O(1)

