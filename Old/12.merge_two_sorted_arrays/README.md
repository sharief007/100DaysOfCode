# NOTES
## Merge two sorted array without using extra space

### Method-1 (Extra space)

1. Initialise a priority queue.
2. Loop through both the arrays and add all elements to priority queue.
3. Loop through priority queue and poll elements and assign to resultant array.

Time Complexity: O(n+m)
Space Complexity: O(n+m)

### Method-2

1. Loop through first array and check each element **a1** with first element **b1** of second array
2. **if (a1>b1)** swap the elements from both arrays and sort the second array.

Time Complexity: O(n*m)
Space Complexity: O(1)

### Method-3 (Gap Method)
![Algorithm](https://lh4.googleusercontent.com/XN0hBLvQqxNevdCS62QeyAQ47t_wcfAbqVFUnUSI9EI_lJcn_KMJ7fzSR7bOUw47FL_BYFEX74bL-GaExa6q_g-bd88KEwEEWHcl-ieqZoAO-0elO42c4b_it0xvNANmfIoVJvj5)
![Algorithm](https://lh3.googleusercontent.com/lyvwTvrtYnwEilU0AZ-PNNVzUNXV72xqmq6UmSnfMCE5GfZXo1pl6EAYTE6RFPLvugNeytrAiM1i6I-E8bTl8Y-VTT-uzJ2VQ6FDZE6-uq-sp9bMrIvizxGqvZeIi4hB6LiGGijL)


Time Complexity: O(nlogn)
Space Complexity: O(1)

#### Related Links

1. [Youtube](https://www.youtube.com/watch?v=hVl2b3bLzBw)
2. [Take you forward](https://takeuforward.org/data-structure/merge-two-sorted-arrays-without-extra-space/)
3. [GFG](https://www.geeksforgeeks.org/efficiently-merging-two-sorted-arrays-with-o1-extra-space/)