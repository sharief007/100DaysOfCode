
[384. Shuffle an Array](https://leetcode.com/problems/shuffle-an-array/)

Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the array should be equally likely as a result of the shuffling.

Implement the Solution class:

Solution(int[] nums) Initializes the object with the integer array nums.
int[] reset() Resets the array to its original configuration and returns it.
int[] shuffle() Returns a random shuffling of the array.

```text
Input
["Solution", "shuffle", "reset", "shuffle"]
[[[1, 2, 3]], [], [], []]
Output
[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]

Explanation
Solution solution = new Solution([1, 2, 3]);
solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
                       // Any permutation of [1,2,3] must be equally likely to be returned.
                       // Example: return [3, 1, 2]
solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
```

### Approach 

- Time Complexity: O(1)
- Space Complexity: O(N)

```java
class Solution {

    private int[] original, copy;
    private final Random random = new Random();
    
    public Solution(int[] nums) {
        original = nums.clone();
        copy = nums;
    }
    
    public int[] reset() {
        return original;
    }
    
    public int[] shuffle() {
        int index = random.nextInt(copy.length - 1);
        swap(copy, index);
        return copy;
    }
    
    private void swap(int[] copy, int index) {
        int temp = copy[index];
        copy[index] = copy[copy.length - 1];
        copy[copy.length - 1] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
```