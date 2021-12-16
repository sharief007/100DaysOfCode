# NOTES
## Move all negative elements to one side of the array

### Union
1. Initialize 2 pointers(indices). **i= 0 and j= 0**
2. loop through the array **while (i<length1 && j<length2)**
3. if a[i] > b[j], then add a[i] to answer and increment i till next distinct value in a.
4. if a[i] < b[j], then add b[j] to answer and increment j till next distinct value in b.
5. if a[i] == b[j], then add a[i] to answer and increment both i,j till next distinct values in a,b.
6. Continue to loop through the larger array and add to answer.

Time Complexity: O(n+m)
Space Complexity: O(1)

### Intersection
1. Initialize 2 pointers(indices). **i= 0 and j= 0**
2. loop through the array **while (i<length1 && j<length2)**
3. if a[i] > b[j], increment i till next distinct value in a.
4. if a[i] < b[j], increment j till next distinct value in b.
5. if a[i] == b[j], then add a[i] to answer and increment both i,j till next distinct values in a,b.

Time Complexity: O(n+m)
Space Complexity: O(1)

