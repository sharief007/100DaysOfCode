# NOTES
## Move all negative elements to one side of the array

### Method-1
1. Initialize 2 pointers(indices). **left= 0 and right= length-1**
2. loop through the array **while (left<right)**
3. if arr[left] >0 and arr[right]> 0 then left++.
4. if arr[left] <0 and arr[right]< 0 then right--.
5. if arr[left] >0 and arr[right]< 0 then swap elements. left++.
6. if arr[left] <0 and arr[right]> 0 then swap elements. left++, right--.

Time Complexity: O(n)
Space Complexity: O(1)

