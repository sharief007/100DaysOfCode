# NOTES
## Find duplicate element in array with N+1 elements

### Method-1

1. Sort the array in ascending order.
2. linearly traverse the array and return if two consequtive elements are same.

Time Complexity: O(n+nlogn)
Space Complexity: O(1)

### Method-2

1. Initialise a HashMap.
2. Traverse the array and check if element present as key in hashmap.
3. if yes, then increment its value.
4. else, add a new map entry with key as current index element and value as 1.
5. traverse the hasmap and return the key whose value is 2.

Time Complexity: O(n)
Space Complexity: O(n)

### Method-3
1. Loop through the array and **add n to every arr[arr[i]%n] element**.
2. Loop through the array and check if any value greater than **2*n**
3. if found return i, else return -1.

Time Complexity: O(n)
Space Complexity: O(1)