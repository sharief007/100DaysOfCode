[1441. Build an Array With Stack Operations](https://leetcode.com/problems/build-an-array-with-stack-operations/)

You are given an array target and an integer n.

In each iteration, you will read a number from list = [1, 2, 3, ..., n].

Build the target array using the following operations:

"Push": Reads a new element from the beginning list, and pushes it in the array.
"Pop": Deletes the last element of the array.
If the target array is already built, stop reading more elements.
Return a list of the operations needed to build target. The test cases are generated so that the answer is unique.

```text
Input: target = [1,3], n = 3
Output: ["Push","Push","Pop","Push"]
Explanation: 
Read number 1 and automatically push in the array -> [1]
Read number 2 and automatically push in the array then Pop it -> [1]
Read number 3 and automatically push in the array -> [1,3]
```

```text
Input: target = [1,2,3], n = 3
Output: ["Push","Push","Push"]
```

```text
Input: target = [1,2], n = 4
Output: ["Push","Push"]
Explanation: You only need to read the first 2 numbers and stop.
```

### Approach 

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new LinkedList<>();
        
        int ptr = 0;
        
        // it is gaurenteed that target array is strictly increasing, so
        for(int i=1; i<=n; i++) {   // list ranges from 1 to 2
            if(ptr == target.length) {
                break;
            } else if (target[ptr] == i) {  // this means number is present
                result.add("Push");
                ptr++;  // we are done with one index
            } else {    // this means number is not present
                result.add("Push");
                result.add("Pop");      // push & pop adds and removes element
            }
        }
        return result;
    }
}
```