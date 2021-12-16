# NOTES
## Largest sum of a contigous sum array

### Kadane's Algorithm

1. Init two variables sum & max.
2. loop through the array and sum = sum of all elements till now
3. max = largest sum till now
4. if sum < 0, then sum =0.

Time Complexity: O(n)
Space Complexity: O(1)

