
[287. Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/)

### Approach - 0

The elements in array lies between the range 1 to N. Since we know the range, we can use/modify the same input array to calculate the number of occurences of elements.

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    public int findDuplicate(int[] nums) {
        int n =nums.length;
        for(int i=0;i<n;i++) {
            nums[nums[i]%n] += n;
        }
        for(int i=0;i<n;i++) {
            if(nums[i]>=2*n) {
                return i;
            }
        }
        return -1;
    }
}
```


### Approach - 1 (Counting)

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
public static int findDuplicate(int[] nums) {
    int len = nums.length;
    int[] cnt = new int[len + 1];
    for (int i = 0; i < len; i++) {
        cnt[nums[i]]++;
        if (cnt[nums[i]] > 1) {
            return nums[i];
        }
    }

    return len;
}
```

### Approach - 2 (Hashset)

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
public static int findDuplicate_set(int[] nums) {
    Set<Integer> set = new HashSet<>();
    int len = nums.length;
    for (int i = 0; i < len; i++) {
        if (!set.add(nums[i])) {
            return nums[i];
        }
    }
    return len;
}
```


### Approach - 3 (Sorting)

- Time Complexity: O(N*logN)
- Space Complexity: O(logN)

```java
public static int findDuplicate_sort(int[] nums) {
    Arrays.sort(nums);
    int len = nums.length;
    for (int i = 1; i < len; i++) {
        if (nums[i] == nums[i - 1]) {
            return nums[i];
        }
    }

    return len;
}
```

### Approach - 4 (Binary Search)

Note that the key is to find an integer in the array [1, 2,.., n] instead of finding an integer in the input array.

We can use the binary search algorithm, each round we guess one number, then scan the input array, narrow the search range, and finally get the answer.

According to the Pigeonhole Principle, n + 1 integers, placed in an array of length n, at least 1 integer will be repeated.

So guess a number first(the number mid in the valid range [left, right]), count the elements of the array which is less than or equal to mid in the array.

If cnt is strictly greater than mid. According to the Pigeonhole Principle, repeated elements are in the interval [left, mid];
Otherwise, the repeated element is in the interval [mid + 1, right].

- Time Complexity: O(N * LogN)
- Space Complexity: O(1)

```java
public static int findDuplicate_bs(int[] nums) {
    int len = nums.length;
    int low = 1;
    int high = len - 1;
    while (low < high) {
        int mid = low + (high - low) / 2;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] <= mid) {
                cnt++;
            }
        }

        if (cnt <= mid) {
            low = mid + 1;
        } else {
            high = mid;
        }
    }

    return low;
}
```

### Approach - 5 (Bit)

This method is convert all the numbers to binary numbers. If we can get each digit of the repeated number in binary, we can rebuild the repeated number.

For example, the ith digit, note that in the nums array, the sum of all the elements whose ith digit is 1 is x as convert the number to binary.

As the range [1, n], we can also count the sum of the number whose ith digit is 1, we denoted it y.

We can easily get that x > y.

The following table lists whether each bit in the binary of each number is 1 or 0 and what the x and y of the corresponding bit are:

|     |  1  |  3  |  4  |  2  |  2  |  x  |  y  |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Bit0 | 1  |  1  |  0  |  0  |  0  |  2  |  2  |
| Bit1 | 1  |  0  |  1  |  1  |  1  |  3  |  2  |
| Bit2 | 0  |  0  |  1  |  0  |  0  |  1  |  1  |

From the table, we found that only the 1th bit x > y, so after bitwise restoration target=(010)_2=(2)_10, which is the answer.

The proof of correctness is actually similar to method 1. We can consider the change of the number x of the i-th in different example arrays.

If target appears twice in the test case array, the rest of the numbers appear once, and the ith bit of target is 1, then the nums array x, is exactly one greater than y. If bit i of target is 0, then both are equal.
If target appears three or more times in the array of test cases, then there must be some numbers that are not in the nums array. At this time, it is equivalent to replacing these with target, we consider the impact on x when replacing:

If the i-th bit of the number to be replaced is 1, and the i-th bit of target is 1: x remains unchanged, x > y.

If the i-th bit of the number being replaced is 0, and the i-th bit of target is 1: x plus one, x > y.

If the i-th bit of the number to be replaced is 1, and the i-th bit of target is 0: x minus one, x <= y.

If the i-th bit of the number to be replaced is 0, and the i-th bit of target is 0: x remains unchanged, satisfying x <= y.

Therefore, if the ith bit of target is 1, then after each replacement, only x will be unchanged or increased. If it is 0, only x will be unchanged or decreased.

When x > y, the ith bit of target is 1, otherwise it is 0. We only need to restore this repeated number bitwise.

- Time Complexity: O(N * log N)
- Space Complexity: O(1)

``` java
public static int findDuplicate_bit(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int bit_max = 31;
        while (((n - 1) >> bit_max) == 0) {
            bit_max -= 1;
        }

        for (int bit = 0; bit <= bit_max; ++bit) {
            int x = 0, y = 0;
            for (int i = 0; i < n; ++i) {
                if ((nums[i] & (1 << bit)) != 0) {
                    x += 1;
                }
                if (i >= 1 && ((i & (1 << bit)) != 0)) {
                    y += 1;
                }
            }
            if (x > y) {
                ans |= 1 << bit;
            }
        }

        return ans;
    }
```

### Approach - 6 (Slow Fast)

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
public int findDuplicate_fastSlow(int[] nums) {
    int slow = 0;
    int fast = 0;
    do {
        slow = nums[slow];
        fast = nums[nums[fast]];
    } while (slow != fast);

    slow = 0;
    while (slow != fast) {
        slow = nums[slow];
        fast = nums[fast];
    }
    
    return slow;
}
```