# NOTES
## Maximum and Minimum element of an Array

### Method-1
1. Sort the array in ascending order.
2. First element is minimum & Last element is Maximum

Time complexity: O(NLogn)

### Method-2
1. Initialize two variables min, max.
2. Linearly traverse the array and compare each element with min & max and update values

Time complexity: O(n)
space complexity: O(1)

### Method-3
1. if array_size = 1
    return element as both max and min
2. else if arry_size = 2
    one comparison to determine max and min
    return that pair
3. else 
    recur for max and min of left half
    recur for max and min of right half
    one comparison determines true max of the two candidates
    one comparison determines true min of the two candidates
    return the pair of max and min

