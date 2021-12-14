# NOTES
## Reversing an Array

### Method-1
1. Push all the elements of array to **Stack**.
2. Pop all elements from **Stack** and store in new array.

Time complexity: O(n)
space complexity: O(n)

### Method -2
1. Initialize two pointers at first and last index of the array.
2. Loop through the array and swap elements at both pointers until first < last.

Time complexity: O(n)
space complexity: O(1)

